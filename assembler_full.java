package eoc_java.Assembler_combined;

import java.util.ArrayList;


public class assembler_full {
    public static ArrayList<String> ConvertTOBinary(String filePath) {
        q4 AInstruction = new q4();
        q5 CInstruction = new q5();
        nowsp fileReader = new nowsp();
        ArrayList<String> result = nowsp.reader(filePath);

        /* Manipulate or use the returned string array as desired*/ 
        int indexCounter = 0;
        int[] array = new int[0];
        for (String str : result) {
            if ((str.charAt(0) != '@') && str.charAt(0) != '(') {
                array = q5.instruction(str, indexCounter);
                String output = "";
                for (int i = 0; i < array.length; i++) {
                    output += Integer.toString(array[i]);
                }
                System.out.println(output + " " + str);
                result.set(indexCounter, output);
            } else {
                System.out.println(str);
                int counter = 16;
                if (q4.aInsruction(str, result, counter) != null) {
                    result.set(indexCounter, q4.aInsruction(str, result, counter));
                    System.out.println(q4.aInsruction(str, result, counter) + " " + str);
                }
            }
            indexCounter++;
        }
        result.remove("(LOOP)");
        result.remove("(INFINITE_LOOP)");

        return result;
    }
    public static void main(String[] args) {
        ArrayList<String> output = assembler_full.ConvertTOBinary("AC.asm");
        System.out.println(output);
    }


}
