import static java.lang.Math.abs;

public class Helper {
    public static int getFirstNumber(char[] arr){
        String num = "";
        int cnt=0,n=0,i;

        while(arr[cnt] >= '0' && arr[cnt] <= '9'){
            num += Character.toString(arr[cnt]);
            cnt++;
        }
        n = Integer.parseInt(num);
        return n;
    }

    public static int getOperationIndex(char arr[]){
        int cnt=0;
        while(arr[cnt] >= '0' && arr[cnt] <= '9') {
            cnt++;
        }
        return cnt;
    }

    public static int getSecondNumber(int temp, char arr[]){
        int n=0,i;
        String num = "";
        for(i=temp;i<arr.length;i++){
            num += Character.toString(arr[i]);
        }
        n = Integer.parseInt(num);
        return n;
    }

    public static char getOperation(int temp, char arr[]){
        return arr[temp-1];
    }

    public static int sum(int x,int y){
        return x+y;
    }

    public static int sub(int x,int y){
        return abs(x-y);
    }

    public static int mul(int x,int y){
        return x*y;
    }

    public static double div(int x,int y){
        double result;
        result = (double)x / (double)y;
        return result;
    }

}
