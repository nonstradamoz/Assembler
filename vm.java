package eoc_java.Assembler_combined;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public  class vm {
    public static ArrayList<String> validate(String[] valArr,String filePath) throws IOException {
        BufferedWriter writer =  new BufferedWriter(new FileWriter("basicout.asm"));
        ArrayList<String> FileOut = new ArrayList<>();
        File file = new File(filePath);
        String fileName = file.getName();
        if(valArr[0].equals("push")){
            switch (valArr[1]){
                case "constant":
                    String push = String.format("@%s D=A @SP AM=M+1 A=A-1 M=D",valArr[2]);
                    String[] pushOut = push.split(" ");
                    FileOut.addAll(Arrays.asList(pushOut));
                    break;
                case "this":
                case "that":
                    String[] pushThisOut = (String.format("@%s D=M @%s A=A+D D=M @SP AM=M+1 A=A-1 M=D ",valArr[1],valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(pushThisOut));
                    break;
                case "local":
                    String[] pushLclOut = (String.format("@%s D=M @%s A=A+D D=M @SP AM=M+1 A=A-1 M=D","LCL",valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(pushLclOut));
                    break;
                case "argument":
                    String[] pushArgOut = (String.format("@%s D=M @%s A=A+D D=M @SP AM=M+1 A=A-1 M=D","ARG",valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(pushArgOut));
                    break;
                case "static":
                    String[] pushStaticOut = (String.format("@%s D=M @%s A=A+D D=M @SP AM=M+1 A=A-1 M=D",String.format("@%s.%d",fileName,valArr[2]),valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(pushStaticOut));
                case "temp":
                    String[] pushTempOut = (String.format("@%s D=M @SP AM=M+1 A=A-1 M=D",String.valueOf(5+Integer.parseInt(valArr[2])))).split(" ");
                    FileOut.addAll(Arrays.asList(pushTempOut));
                    break;
            }
        } else if ((valArr[0].equals("pop"))){
            switch (valArr[1]){
                case "this":
                 case "that":
                    String[] ThisThatOut = (String.format("@%s D=M @%s D=D+A @R13 M=D @SP AM=M-1 D=M @R13 A=M M=D",valArr[1],valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(ThisThatOut));
                    break;
                case "local":
                    String[] LclOut = (String.format("@%s D=M @%s D=D+A @R13 M=D @SP AM=M-1 D=M @R13 A=M M=D","LCL",valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(LclOut));
                    break;
                case "argument":
                    String[] ArgOut = (String.format("@%s D=M @%s D=D+A @R13 M=D @SP AM=M-1 D=M @R13 A=M M=D","ARG",valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(ArgOut));
                    break;
                case "temp":
                    String[] TempOut = (String.format("@%s M=D",String.valueOf(5+Integer.parseInt(valArr[2])))).split(" ");
                    FileOut.addAll(Arrays.asList(TempOut));
                    break;
                case "static":
                    String[] staticOut = (String.format("@%s D=M @%s D=D+A @R13 M=D @SP AM=M-1 D=M @R13 A=M M=D",String.format("@%s.%d",fileName,valArr[2]),valArr[2])).split(" ");
                    FileOut.addAll(Arrays.asList(staticOut));
                    break;
            }
        }else {
            switch (valArr[0]){
                case "add":
                    String[] addOut = {"@SP","AM=M-1","D=M","A=A-1","M=D+M"};
                    FileOut.addAll(Arrays.asList(addOut));
                    break;
                case "sub":
                    String[] subOut = {"@SP","AM=M-1","D=M","A=A-1","M=M-D"};
                    FileOut.addAll(Arrays.asList(subOut));
                    break;
            }
        }
        return FileOut;
    }
}