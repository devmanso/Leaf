package Leaf.Source;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        ScriptExecutor scriptExecutor = new ScriptExecutor();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String file = scanner.nextLine();

        ScriptExecutor.loadScript(file);
        scanner.close();
    }

    
}