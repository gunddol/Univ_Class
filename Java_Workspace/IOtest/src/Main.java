import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String quest = keyboard.nextLine();
        String[] info = quest.split(" ");

        int name_leng = info.length - 1;
        System.out.println("Name Length(Korean) : " + name_leng);

        String[] first_name = info[0].split("");
        first_name[0] = first_name[0].toUpperCase();

        int i;
        for(i=1;i<name_leng;i++) {
            String[] other_name = info[i].split("");
            System.out.printf("%s.",other_name[0].toUpperCase());
        }
        System.out.printf(first_name[0]);
        for(i=1;i<info[0].length();i++){
            System.out.printf(first_name[i]);
        }

        String imsi = info[name_leng];
        imsi = imsi.replace("ppt","pdf");

        String[] file_name = imsi.split("");
        file_name[0] = file_name[0].toUpperCase();

        System.out.printf(" ");
        for(i=0;i<file_name.length;i++) {
            System.out.printf(file_name[i]);
        }
        System.out.println();
    }
}