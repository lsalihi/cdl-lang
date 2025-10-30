grammar CDL;

program: statement* EOF;

statement: intent | rule | policy | flow | mapping | typeDef;

intent: 'intent' ID meta* 'end';

rule: 'rule' ID meta* 'end';

policy: 'policy' ID meta* 'end';

flow: 'flow' ID step+ 'end';

mapping: 'mapping' ID '->' target meta* 'end';

typeDef: 'type' ID field* 'end';

field: LOWER_ID ':' typeRef ('where' expression)?;

typeRef: ID | parameterizedType;

parameterizedType: ID '(' parameters ')';

parameters: parameter (',' parameter)*;

parameter: LOWER_ID ':' typeRef;

expression: term (('and' | 'or') term)*;

term: atom (comparisonOp atom)*;

atom: LOWER_ID | NUMBER | STRING | functionCall;

comparisonOp: '>' | '<' | '>=' | '<=' | '==' | '!=' | 'in';

functionCall: LOWER_ID '(' arguments? ')';

arguments: expression (',' expression)*;

meta: key ':' value;

key: ID | LOWER_ID;

LOWER_ID: [a-z_][a-z0-9_]*;

value: STRING | ID | list | NUMBER;

list: '[' (value (',' value)*)? ']';

step: 'start' ID | 'then' ID ('when' condition)?;

condition: ID '==' STRING;

target: STRING | ID;

ID: [A-Z_][A-Z0-9_]*;

STRING: '"' (~["\\] | '\\' .)* '"';

NUMBER: [0-9]+ ('.' [0-9]+)?;

WS: [ \t\r\n]+ -> skip;
