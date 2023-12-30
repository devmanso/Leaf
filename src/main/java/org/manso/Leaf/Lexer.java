package org.manso.Leaf;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private int currentPosition;

    public Lexer(String input) {
        this.input = input;
        this.currentPosition = 0;
    }

    public List<Token> lex() {
        List<Token> tokens = new ArrayList<>();

        while (currentPosition < input.length()) {
            char currentChar = input.charAt(currentPosition);

            // Implement logic to identify tokens here

            // Example: Check for whitespace and move to the next character
            if (Character.isWhitespace(currentChar)) {
                currentPosition++;
                continue;
            }

            // Example: Check for identifiers or keywords
            if (Character.isLetter(currentChar)) {
                StringBuilder identifier = new StringBuilder();
                while (currentPosition < input.length() && (Character.isLetterOrDigit(input.charAt(currentPosition)))) {
                    identifier.append(input.charAt(currentPosition));
                    currentPosition++;
                }

                // Check if the identifier is a keyword
                TokenType type = determineTokenType(identifier.toString());
                tokens.add(new Token(type, identifier.toString()));
                continue;
            }

            // Check for data types (str, int, bool, num)
            if (currentChar == 's' && input.charAt(currentPosition + 1) == 't' && input.charAt(currentPosition + 2) == 'r') {
                tokens.add(new Token(TokenType.STR, "str"));
                currentPosition += 3;
                continue;
            } else if (currentChar == 'i' && input.charAt(currentPosition + 1) == 'n' && input.charAt(currentPosition + 2) == 't') {
                tokens.add(new Token(TokenType.INT, "int"));
                currentPosition += 3;
                continue;
            } else if (currentChar == 'b' && input.charAt(currentPosition + 1) == 'o' && input.charAt(currentPosition + 2) == 'o' && input.charAt(currentPosition + 3) == 'l') {
                tokens.add(new Token(TokenType.BOOL, "bool"));
                currentPosition += 4;
                continue;
            } else if (currentChar == 'n' && input.charAt(currentPosition + 1) == 'u' && input.charAt(currentPosition + 2) == 'm') {
                tokens.add(new Token(TokenType.DECIMAL, "num"));
                currentPosition += 3;
                continue;
            }

            // Check for math symbols
            if (currentChar == '+') {
                tokens.add(new Token(TokenType.PLUS, "+"));
                currentPosition++;
                continue;
            } else if (currentChar == '-') {
                tokens.add(new Token(TokenType.MINUS, "-"));
                currentPosition++;
                continue;
            } else if (currentChar == '*') {
                tokens.add(new Token(TokenType.ASTERISK, "*"));
                currentPosition++;
                continue;
            } else if (currentChar == '/') {
                // Check for commment (another slash)
                if (input.charAt(currentPosition + 1) == '/') {
                    tokens.add(new Token(TokenType.COMMENT, "//"));
                    currentPosition += 2;
                    continue;
                }
                tokens.add(new Token(TokenType.SLASH, "/"));
                currentPosition++;
                continue;
            } else if (currentChar == '%') {
                tokens.add(new Token(TokenType.PERCENT, "%"));
                currentPosition++;
                continue;
            } else if (currentChar == '>') {
                if (input.charAt(currentPosition + 1) == '=') {
                    tokens.add(new Token(TokenType.GREATER_THAN_OR_EQUAL, ">="));
                    currentPosition += 2;
                    continue;
                } else {
                    tokens.add(new Token(TokenType.GREATER_THAN, ">"));
                    currentPosition++;
                    continue;
                }
            } else if (currentChar == '<') {
                if (input.charAt(currentPosition + 1) == '=') {
                    tokens.add(new Token(TokenType.LESS_THAN_OR_EQUAL, "<="));
                    currentPosition += 2;
                    continue;
                } else {
                    tokens.add(new Token(TokenType.LESS_THAN, "<"));
                    currentPosition++;
                    continue;
                }
            } else if (currentChar == '=') {
                if (input.charAt(currentPosition + 1) == '=') {
                    tokens.add(new Token(TokenType.EQUAL, "=="));
                    currentPosition += 2;
                    continue;
                } else {
                    tokens.add(new Token(TokenType.ASSIGN, "="));
                    currentPosition++;
                    continue;
                }
            } else if (currentChar == '!') {
                if (input.charAt(currentPosition + 1) == '=') {
                    tokens.add(new Token(TokenType.NOT_EQUAL, "!="));
                    currentPosition += 2;
                    continue;
                }
            }

            // Check for parentheses and similar symbols
            if (currentChar == '(') {
                tokens.add(new Token(TokenType.OPEN_PAREN, "("));
                currentPosition++;
                continue;
            } else if (currentChar == ')') {
                tokens.add(new Token(TokenType.CLOSE_PAREN, ")"));
                currentPosition++;
                continue;
            } else if (currentChar == '{') {
                tokens.add(new Token(TokenType.OPEN_BRACE, "{"));
                currentPosition++;
                continue;
            } else if (currentChar == '}') {
                tokens.add(new Token(TokenType.CLOSE_BRACE, "}"));
                currentPosition++;
                continue;
            } else if (currentChar == ';') {
                tokens.add(new Token(TokenType.SEMICOLON, ";"));
                currentPosition++;
                continue;
            } else if (currentChar == ',') {
                tokens.add(new Token(TokenType.COMMA, ","));
                currentPosition++;
                continue;
            }

            currentPosition++;
        }

        return tokens;
    }

    private TokenType determineTokenType(String identifier) {
        // Implement logic to determine the TokenType for identifiers/keywords
        // You can use a switch statement or if-else conditions

        // Example: Check if the identifier is a keyword
        switch (identifier) {
            case "if":
                return TokenType.IF;
            case "else":
                return TokenType.ELSE;
            case "while":
                return TokenType.WHILE;
            case "for":
                return TokenType.FOR;
            case "str":
                return TokenType.STR;
            case "int":
                return TokenType.INT;
            case "bool":
                return TokenType.BOOL;
            case "num":
                return TokenType.DECIMAL;
            case "+":
                return TokenType.PLUS;
            case "-":
                return TokenType.MINUS;
            case "*":
                return TokenType.ASTERISK;
            case "/":
                return TokenType.SLASH;
            case "%":
                return TokenType.PERCENT;
            case ">":
                return TokenType.GREATER_THAN;
            case "<":
                return TokenType.LESS_THAN;
            case "<=":
                return TokenType.LESS_THAN_OR_EQUAL;
            case ">=":
                return TokenType.GREATER_THAN_OR_EQUAL;
            case "==":
                return TokenType.EQUAL;
            case "!=":
                return TokenType.NOT_EQUAL;
            case "=":
                return TokenType.ASSIGN;
            case "(":
                return TokenType.OPEN_PAREN;
            case ")":
                return TokenType.CLOSE_PAREN;
            case "{":
                return TokenType.OPEN_BRACE;
            case "}":
                return TokenType.CLOSE_BRACE;
            case ";":
                return TokenType.SEMICOLON;
            case ",":
                return TokenType.COMMA;
            case "//":
                return TokenType.COMMENT;
            default:
                return TokenType.ID; // Default to identifier
        }
    }
}
