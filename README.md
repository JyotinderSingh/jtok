# jtok

This repository is an effort to build an interpreter for a programming language called **Tok** *(pronounced 'talk')*.

jtok *(pronounced 'jay-talk')* is a Tree-Walk Java interpreter for Tok.

The implementation includes a **REPL** and a **CLI interpreter.**

Head over to the [Documentation](/DOCUMENTATION.md) to see code examples and other language features!

```
                   jtok architecture
                
            ------------
           |   Parser   |       <- Front End
            ------------
                  v
            ------------
           |     AST    |       <- Representation
            ------------
                  v
            ------------
           | Interpreter|       <- Execution
            ------------
```

## The Tok Language Spec

The Tok grammar looks something like this, in order of associativity and precedence:

```
program        → statement* EOF ;

declaration    → classDecl
                 | funDecl
                 | varDecl
                 | statement ;

classDecl      → "class" IDENTIFIER ( "<" IDENTIFIER )?
                 "{" function* "}" ;             
                 
funDecl        → "fun" function ;

function       → IDENTIFIER "(" parameters? ")" block ;             

parameters     → IDENTIFIER ( "," IDENTIFIER )* ;
                 
varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;

statement      → exprStmt
                 | forStmt
                 | ifStmt
                 | printStmt
                 | returnStmt
                 | whileStmt
                 | block ;

returnStmt     → "return" expression? ";" ;

forStmt        → "for" "(" ( varDecl | exprStmt | ";" )
                 expression? ";"
                 expression? ")" statement ;

whileStmt      → "while" "(" expression ")" statement ;

ifStmt         → "if" "(" expression ")" statement
                 ( "else" statement )? ;

block          → "{" declaration* "}" ;

exprStmt       → expression ";" ;

printStmt      → "print" expression ";" ;

expression     → assignment ;

assignment     → ( call "." )? IDENTIFIER "=" assignment
                 | logic_or ;
               
logic_or       → logic_and ( "or" logic_and )* ;

logic_and      → equality ( "and" equality )* ;

equality       → comparison ( ( "!=" | "==" ) comparison )* ;

comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;

term           → factor ( ( "-" | "+" ) factor )* ;

factor         → unary ( ( "/" | "*" ) unary )* ;

unary          → ( "!" | "-" ) unary | call ;

call           → primary ( "(" arguments? ")" | "." IDENTIFIER )* ;

arguments      → expression ( "," expression )* ;

primary        → "true" | "false" | "nil" | "this"
               | NUMBER | STRING | IDENTIFIER | "(" expression ")"
               | "super" "." IDENTIFIER ;

```


I started working on this after reading [Bob Nystrom](https://journal.stuffwithstuff.com/) 's book, Crafting
Interpreters.
