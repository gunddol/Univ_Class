import kr.co.Lab07_2.Collection.Employee;

import java.util.Scanner;

public class Program {
    public static void  main(String args[]){
        double random = Math.random() * 100;
        Scanner scan = new Scanner(System.in);

        String name = scan.next();
        double salary = Double.parseDouble(scan.next());

        Employee em = new Employee(name, salary);

        System.out.println("이름 : " + em.getName());
        System.out.println("연봉 : " + em.getSalary());

        em.raiseSalary(random);

        System.out.println("이름 : " + em.getName());
        System.out.println("연봉 : " + em.getSalary());
    }
}
