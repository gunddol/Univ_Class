import java.util.Scanner;

public class Program {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String msg = scan.nextLine();

        int firstnum = Helper.getFirstNumber(msg.toCharArray());
        int temp = Helper.getOperationIndex(msg.toCharArray()) + 1;
        int secondNum = Helper.getSecondNumber(temp, msg.toCharArray());

        switch(Helper.getOperation(temp, msg.toCharArray())){
            case '+' : System.out.println(Helper.sum(firstnum, secondNum)); break;
            case '-' : System.out.println(Helper.sub(firstnum, secondNum)); break;
            case '*' : System.out.println(Helper.mul(firstnum, secondNum)); break;
            case '/' : System.out.println(Helper.div(firstnum, secondNum)); break;
        }
        
    }
}
