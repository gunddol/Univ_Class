import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];

//        System.out.println(arr[0]);
        arr = inputdata(arr, scan);

        int sum = getSum(arr);

        System.out.println("합계 : " + sum);
    }

    private static int getSum(int[] arr) throws Exception{
        int sum = 0,i;
        for(i=0;i<3;i++) {
            try {
                if (arr[i] > 0)
                    sum += arr[i];
                else if(arr[i] < 0){
                    System.out.println((i + 1) + "번째 값이 음수이므로 그 전값까지의 합계를 계산합니다.");
                    break;
                }else{
                    throw new NullPointerException();
                }
            } catch (NullPointerException ex) {
                System.out.println("배열의 값이 null입니다.");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sum;
    }

    private static int[] inputdata(int[] arr, Scanner scan){
        int i,j;
        for(i=0;i<arr.length;i++) {
            try {
                System.out.print(i+1 + "번째 값 입력 : ");
                arr[i] = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("숫자를 입력하지 않아, 프로그램이 종료됩니다.");
                for(j=0;j<arr.length;j++) arr[j] = 0;
                break;
            }
        }
        return arr;
    }
}
