import java.util.*;

public class Bank {
    ArrayList<Account> accounts;
    public void run(){
        Scanner scan = new Scanner(System.in);
        accounts = new ArrayList<Account>();

        System.out.println("국가선택");
        System.out.println("1) 한국");
        System.out.println("2) 미국");

        int select = scan.nextInt();

        switch(select){
            case 1: setKorean(); break;
            case 2: setAmerican(); break;
            default : System.out.println("프로그램 종료");
        }
    }

    public void setKorean(){
        int money=0;
        for(int i=0;i<5;i++){
            money = (int)(Math.random() * 10000) + 1;
            accounts.add(new Account<Integer>(money));
        }

        Collections.sort(accounts, new Comparator<Account>(){
            @Override
            public int compare(Account arg0, Account arg1){
                if((int)arg0.data < (int)arg1.data) return -1;
                else return 1;
            }
        });

        for(Account i : accounts){
            System.out.println(i.data);
        }

    }

    public void setAmerican(){
        int m;
        double money;
        for(int i=0;i<5;i++){
            m = (int)(Math.random() * 10000) + 1;
            money = (double)m / 100;
            accounts.add(new Account<Double>(money));
        }

        Collections.sort(accounts, new Comparator<Account>(){
            @Override
            public int compare(Account arg0, Account arg1){
                if((double)arg0.data < (double)arg1.data) return -1;
                else return 1;
            }
        });

        for(Account i : accounts){
            System.out.println(i.data);
        }
    }
}
