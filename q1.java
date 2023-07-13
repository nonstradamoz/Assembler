package eoc_java.Assembler_combined;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class q1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("trial.asm"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("removed.asm"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s+", "");

                if (line.startsWith("\n") || line.startsWith("/")) {
                    continue;
                }

                if (line.contains("/")) {
                    int index = line.indexOf("/");
                    line = line.substring(0, index) + "\n";
                }

                if (reader.ready()) {
                    line = line.strip();
                }

                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
