import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String filename = "data.txt";
        Scanner inputstream = null;

        File fileobject = new File(filename);
        if(fileobject.exists()){
            String line;
            int cnt=0;

            try {
                inputstream = new Scanner(new FileInputStream(filename));
                System.out.println(filename);
            }catch (FileNotFoundException e){
                System.out.println("File opening err");
                System.exit(0);
            }

            while(inputstream.hasNextLine()){
                line = inputstream.nextLine();
                String[] tmp;
                tmp = line.split("\t");
                System.out.println("이름 : " + tmp[0]);
                System.out.println("점수 : " + tmp[1]);
            }
        }else{
            String name, score;
            System.out.println(filename + " was not found");

            PrintWriter outputStream = null;
            try{
                outputStream= new PrintWriter(new FileOutputStream(filename));
            }catch (FileNotFoundException e){
                System.out.println("File opening err" + filename);
                System.exit(0);
            }

            for(int i=0;i<2;i++) {
                System.out.print("이름 : ");
                name = keyboard.next();
                System.out.print("점수 : ");
                score = keyboard.next();

                outputStream.println(name + "\t" + score);
            }

            outputStream.close();
        }
    }
}
