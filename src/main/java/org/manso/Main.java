package org.manso;

import org.manso.Leaf.Lexer;
import org.manso.Leaf.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // testing out the lexer
        String input = "int a = 10; bool b = true; str y = 'hello, world'; num m = 10.2;" +
                "// == != >= < > <=" +
                "if (x > 0) { x = x - 1; } else { x = x + 1; }";
        input = "//";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.lex();

        // Print the resulting tokens
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}