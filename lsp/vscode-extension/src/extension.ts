import * as vscode from 'vscode';
import * as path from 'path';
import * as cp from 'child_process';

export function activate(context: vscode.ExtensionContext) {
    console.log('CDL Language Support extension is now active!');

    // Register commands
    const generateOpenAPI = vscode.commands.registerCommand('cdl.generateOpenAPI', async () => {
        await runCDLCommand('gen openapi');
    });

    const lintCommand = vscode.commands.registerCommand('cdl.lint', async () => {
        await runCDLCommand('lint');
    });

    const formatCommand = vscode.commands.registerCommand('cdl.format', async () => {
        await runCDLCommand('fmt');
    });

    context.subscriptions.push(generateOpenAPI, lintCommand, formatCommand);

    // Register language features
    context.subscriptions.push(
        vscode.languages.registerDocumentFormattingEditProvider('cdl', {
            provideDocumentFormattingEdits(document: vscode.TextDocument): vscode.TextEdit[] {
                return formatDocument(document);
            }
        })
    );

    // Auto-lint on save
    const config = vscode.workspace.getConfiguration('cdl');
    if (config.get('lint.onSave')) {
        context.subscriptions.push(
            vscode.workspace.onDidSaveTextDocument((document) => {
                if (document.languageId === 'cdl') {
                    runCDLCommand('lint', false);
                }
            })
        );
    }
}

function formatDocument(document: vscode.TextDocument): vscode.TextEdit[] {
    const formatted = runCDLSync('fmt', document.getText());
    if (formatted) {
        const range = new vscode.Range(
            document.positionAt(0),
            document.positionAt(document.getText().length)
        );
        return [vscode.TextEdit.replace(range, formatted)];
    }
    return [];
}

async function runCDLCommand(subcommand: string, showOutput: boolean = true) {
    const activeEditor = vscode.window.activeTextEditor;
    if (!activeEditor || activeEditor.document.languageId !== 'cdl') {
        vscode.window.showErrorMessage('No CDL file is currently open');
        return;
    }

    const document = activeEditor.document;
    const filePath = document.uri.fsPath;

    try {
        const output = await runCDLAsync(subcommand, filePath);
        if (showOutput && output) {
            const outputChannel = vscode.window.createOutputChannel('CDL');
            outputChannel.show();
            outputChannel.appendLine(output);
        }
    } catch (error) {
        vscode.window.showErrorMessage(`CDL ${subcommand} failed: ${error}`);
    }
}

function runCDLSync(subcommand: string, input?: string): string | null {
    const config = vscode.workspace.getConfiguration('cdl');
    const cliPath = config.get('cli.path') as string || 'cdl';

    try {
        const args = subcommand.split(' ');
        if (input) {
            args.push('-');
        }

        const result = cp.spawnSync(cliPath, args, {
            input: input,
            encoding: 'utf8'
        });

        if (result.status === 0) {
            return result.stdout;
        } else {
            console.error('CDL command failed:', result.stderr);
            return null;
        }
    } catch (error) {
        console.error('Failed to run CDL command:', error);
        return null;
    }
}

async function runCDLAsync(subcommand: string, filePath?: string): Promise<string> {
    return new Promise((resolve, reject) => {
        const config = vscode.workspace.getConfiguration('cdl');
        const cliPath = config.get('cli.path') as string || 'cdl';

        const args = subcommand.split(' ');
        if (filePath) {
            args.push('-i', filePath);
        }

        const process = cp.spawn(cliPath, args, {
            cwd: vscode.workspace.workspaceFolders?.[0]?.uri.fsPath
        });

        let stdout = '';
        let stderr = '';

        process.stdout.on('data', (data) => {
            stdout += data.toString();
        });

        process.stderr.on('data', (data) => {
            stderr += data.toString();
        });

        process.on('close', (code) => {
            if (code === 0) {
                resolve(stdout);
            } else {
                reject(new Error(stderr || `CDL command failed with code ${code}`));
            }
        });

        process.on('error', (error) => {
            reject(error);
        });
    });
}

export function deactivate() {
    console.log('CDL Language Support extension deactivated');
}
