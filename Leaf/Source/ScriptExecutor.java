package Leaf.Source;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScriptExecutor {

    public static class Analyzer {

        public static void quote(String line) {
            if(line.startsWith("'") && line.endsWith("'")) {
                // omit first and last char of string
                // this is so we can get rid of '' before we print the text
                String text = line.substring(1, line.length() -1);
                
                System.out.println(text);
            }
        }
    }

    public static void executeScript(FileReader fileReader, BufferedReader bufferedReader) {
        // Read file line-by-line
        String line;

        try {
            while ( (line = bufferedReader.readLine()) != null) {
                Analyzer.quote(line);
            }
        } catch(IOException executionError) {
            executionError.printStackTrace();
        }
    }

    public static void loadScript(String filename) {
        String filepath = filename;

        // read the file
        FileReader fileReader = null;

        // read file line by line
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);
            executeScript(fileReader, bufferedReader);
        } catch (IOException fileError) {
            System.err.println("FILE ERROR");
            fileError.printStackTrace();
        } finally {
            // close file
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                } 
                if(fileReader != null) {
                    fileReader.close();
                }

            } catch(IOException closingFileError) {
                System.err.println("CLOSING FILE ERROR");
                closingFileError.printStackTrace();
            }
        }
    }
}
