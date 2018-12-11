package kr.co.Lab07_2.Collection;

public class Employee {
    public String name;
    public double salary;

    /**
     * Employee 클래스의 생성자
     * @param _name 직원의 이름
     * @param _salary 직원의 급여
     */
    public Employee(String _name, double _salary){
        this.name = _name;
        this.salary = _salary;
    }

    /**
     * @return 직원의 이름을 반환한다.
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return 직원의 급여를 반환한다.
     */
    public double getSalary(){

        return this.salary;
    }

    /**
     * 급여 인상률을 받아 출력하고 급여에 적용시키는 method
     * @param byPercent 급여 인상률을 double 형태로 입력받는다.
     */
    public void raiseSalary(double byPercent){

        int raise = (int) byPercent;

        System.out.println("연봉이 " + raise + "% 인상되었습니다.");

        this.salary += this.salary * raise / 100;
    }
}
