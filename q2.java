package eoc_java.Assembler_combined;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class q2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("removed.asm"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("symbols_variables.asm"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (check(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean check(String line) {
        if (line.startsWith("@")) {
            if (Character.isUpperCase(line.charAt(1))) {
                return true;
            } else if (line.charAt(1) == 'R' || Character.isLowerCase(line.charAt(1))) {
                return true;
            }
        } else if (line.startsWith("(")) {
            return true;
        }
        return false;
    }
}

