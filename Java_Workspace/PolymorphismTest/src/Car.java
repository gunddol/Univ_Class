public abstract class Car extends Vehicle{
    public void drive(String a, String b){
        System.out.println(a + "부터 " + b + "까지 운행합니다.");
    }

    @Override
    public void printWheelCount(){
        System.out.println("바퀴 개수 : 4");
    }
}
