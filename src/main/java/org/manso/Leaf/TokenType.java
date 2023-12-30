package org.manso.Leaf;

public enum TokenType {
    // Control
    IF,
    ELSE,
    WHILE,
    FOR,
    // Data types
    STR,
    INT,
    BOOL,
    DECIMAL,
    // Math symbols
    PLUS,
    MINUS,
    SLASH,
    ASTERISK,
    PERCENT,
    LESS_THAN,
    GREATER_THAN,
    EQUAL,
    NOT_EQUAL,
    LESS_THAN_OR_EQUAL,
    GREATER_THAN_OR_EQUAL,
    ASSIGN,
    // Other
    ID,
    OPEN_PAREN,
    CLOSE_PAREN,
    OPEN_BRACE,
    CLOSE_BRACE,
    COMMENT,
    COMMA,
    SEMICOLON,

    UNKNOWN

}
