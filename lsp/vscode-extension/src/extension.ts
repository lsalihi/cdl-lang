
import * as vscode from 'vscode';
import { exec } from 'child_process';
import * as path from 'path';

const DIAG_SOURCE = 'cdl';

function runCli(cmd: string, cwd: string): Promise<{ code: number, stdout: string, stderr: string }> {
  return new Promise((resolve) => {
    exec(cmd, { cwd, windowsHide: true }, (error, stdout, stderr) => {
      resolve({ code: error ? (error as any).code ?? 1 : 0, stdout, stderr });
    });
  });
}

function parseDiagnostics(output: string): vscode.Diagnostic[] {
  const diags: vscode.Diagnostic[] = [];
  const lines = output.split(/\r?\n/);

  for (const line of lines) {
    // Try to match structured error format: [CODE] message at line:column
    const structuredMatch = line.match(/\[([A-Z]\d{3})\]\s*(.+?)\s+at\s+(\d+):(\d+)/);
    if (structuredMatch) {
      const [, code, message, lineNum, colNum] = structuredMatch;
      const lineNo = Math.max(0, parseInt(lineNum, 10) - 1);
      const colNo = Math.max(0, parseInt(colNum, 10) - 1);

      let severity = vscode.DiagnosticSeverity.Error;
      // Type checking errors are warnings for now, actual errors are compilation errors
      if (code.startsWith('E0') && ['E004', 'E005', 'E006', 'E007'].includes(code)) {
        severity = vscode.DiagnosticSeverity.Warning;
      }

      diags.push(new vscode.Diagnostic(
        new vscode.Range(lineNo, colNo, lineNo, colNo + 50),
        `${code}: ${message}`,
        severity
      ));
      continue;
    }

    // Fallback to simple patterns for backward compatibility
    const simpleMatch = line.match(/line\s+(\d+)\s*[:,]\s*(.*)$/i) ||
                       line.match(/Ln\s+(\d+).*?:\s*(.*)$/i) ||
                       line.match(/Error:\s*(.+)$/i);

    if (simpleMatch) {
      const lineNum = simpleMatch[1] ? parseInt(simpleMatch[1], 10) - 1 : 0;
      const message = simpleMatch[2] || simpleMatch[1] || 'Error';
      diags.push(new vscode.Diagnostic(
        new vscode.Range(lineNum, 0, lineNum, 120),
        message,
        vscode.DiagnosticSeverity.Error
      ));
    }
  }

  return diags;
}

export function activate(context: vscode.ExtensionContext) {
  const diagnostics = vscode.languages.createDiagnosticCollection('cdl');
  context.subscriptions.push(diagnostics);

  const cfg = () => vscode.workspace.getConfiguration('cdl');
  const resolveCli = () => cfg().get<string>('cdl.cliPath', 'cdl');

  // Hover provider for type information
  const hoverProvider = vscode.languages.registerHoverProvider('cdl', {
    provideHover(document, position, token) {
      const wordRange = document.getWordRangeAtPosition(position, /[a-zA-Z_][a-zA-Z0-9_]*/);
      if (!wordRange) return;

      const word = document.getText(wordRange);

      // Built-in types
      const builtInTypes: { [key: string]: string } = {
        'string': 'Built-in type for text values\n\nExample: `"John Doe"`',
        'int': 'Built-in type for integer numbers\n\nExample: `42`, `-100`',
        'decimal': 'Built-in type for decimal numbers\n\nExample: `19.99`, `3.14159`',
        'bool': 'Built-in type for boolean values\n\nExample: `true`, `false`',
        'date': 'Built-in type for dates\n\nFormat: YYYY-MM-DD\nExample: `2023-12-25`',
        'datetime': 'Built-in type for date and time\n\nFormat: ISO 8601\nExample: `2023-12-25T14:30:00Z`',
        'Email': 'Built-in type for email addresses\n\nValidates RFC 5322 format',
        'Money': 'Built-in parameterized type for monetary values\n\nExample: `Money(EUR)`, `Money(USD)`'
      };

      // Keywords
      const keywords: { [key: string]: string } = {
        'type': 'Define a new data type\n\n```cdl\ntype Customer\n  name: string\n  email: Email\nend\n```',
        'intent': 'Define a business intent\n\n```cdl\nintent PROCESS_PAYMENT\n  goal: "Process payment"\n  inputs: "[amount: Money]"\nend\n```',
        'where': 'Define constraints on type fields\n\n```cdl\nage: int where age >= 18\n```',
        'mapping': 'Map intent to external API\n\n```cdl\nmapping PROCESS_PAYMENT -> "api POST /payments"\n```'
      };

      // Functions
      const functions: { [key: string]: string } = {
        'length': 'Get string length\n\n`length(field) > 0`',
        'contains': 'Check if string contains substring\n\n`contains(email, "@")`',
        'startsWith': 'Check if string starts with prefix\n\n`startsWith(iban, "FR")`',
        'endsWith': 'Check if string ends with suffix\n\n`endsWith(filename, ".cdl")`',
        'today': 'Get current date\n\n`executionDate >= today()`'
      };

      if (builtInTypes[word]) {
        return new vscode.Hover(builtInTypes[word]);
      }

      if (keywords[word]) {
        return new vscode.Hover(keywords[word]);
      }

      if (functions[word]) {
        return new vscode.Hover(functions[word]);
      }

      return null;
    }
  });

  context.subscriptions.push(hoverProvider);

  async function lint(doc?: vscode.TextDocument) {
    const document = doc ?? vscode.window.activeTextEditor?.document;
    if (!document || document.languageId !== 'cdl') return;
    const cli = resolveCli();
    const cwd = path.dirname(document.uri.fsPath);
    const cmd = `${cli} lint -i "${document.uri.fsPath}"`;
    const res = await runCli(cmd, cwd);
    const diags = parseDiagnostics(res.stderr || res.stdout);
    diagnostics.set(document.uri, diags);
    if (diags.length === 0) {
      vscode.window.setStatusBarMessage('CDL: Lint OK', 2000);
    } else {
      vscode.window.setStatusBarMessage(`CDL: ${diags.length} issue(s)`, 3000);
    }
  }

  // Commands
  context.subscriptions.push(vscode.commands.registerCommand('cdl.lint', () => lint()));

  context.subscriptions.push(vscode.commands.registerCommand('cdl.build', async () => {
    const editor = vscode.window.activeTextEditor;
    if (!editor) { return; }
    const cli = resolveCli();
    const outUri = vscode.Uri.joinPath(editor.document.uri, '../out.ir.json');
    const cmd = `${cli} build -i "${editor.document.uri.fsPath}" -o "${outUri.fsPath}"`;
    const res = await runCli(cmd, path.dirname(editor.document.uri.fsPath));
    if (res.code === 0) {
      vscode.window.showInformationMessage(`CDL: IR generated → ${outUri.fsPath}`);
    } else {
      vscode.window.showErrorMessage('CDL build failed. See OUTPUT > CDL.');
    }
  }));

  context.subscriptions.push(vscode.commands.registerCommand('cdl.generateOpenAPI', async () => {
    const editor = vscode.window.activeTextEditor;
    if (!editor) { return; }
    const cli = resolveCli();
    const cfgOut = cfg().get<string>('cdl.openapiOutput', 'out/api.openapi.yaml');
    const outPath = path.isAbsolute(cfgOut) ? cfgOut : path.join(path.dirname(editor.document.uri.fsPath), cfgOut);
    const cmd = `${cli} gen openapi -i "${editor.document.uri.fsPath}" -o "${outPath}"`;
    const res = await runCli(cmd, path.dirname(editor.document.uri.fsPath));
    if (res.code === 0) {
      vscode.window.showInformationMessage(`CDL: OpenAPI generated → ${outPath}`);
    } else {
      vscode.window.showErrorMessage('CDL OpenAPI generation failed. See OUTPUT > CDL.');
    }
  }));

  // On-save diagnostics
  vscode.workspace.onDidSaveTextDocument((doc) => {
    if (cfg().get<boolean>('cdl.enableOnSave', true) && doc.languageId === 'cdl') {
      lint(doc);
    }
  });

  // First activation lint if a CDL file is open
  if (vscode.window.activeTextEditor?.document.languageId === 'cdl') {
    lint(vscode.window.activeTextEditor.document);
  }
}

export function deactivate() {}
