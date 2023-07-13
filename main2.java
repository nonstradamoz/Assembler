package eoc_java.Assembler_combined;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class main2 {
    public static void main(String[] args) throws IOException {
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("basicout.asm"));
        nowsp remover = new nowsp();
        String filePath = "basictest.vm";
        ArrayList<String> vmCode = nowsp.reader("basictest.vm");
        
        for(int i = 0 ; i < vmCode.size() ; i++){
            
           ArrayList<String> result = vm.validate(vmCode.get(i).split(" "),filePath);
           for (String s : result){
               writer.write(s + "\n");
               System.out.println(s + "\n");
           }

        }
        writer.close();
    }
}
