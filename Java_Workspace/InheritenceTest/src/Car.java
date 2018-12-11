public class Car extends Vehicle{
    private int door_count;

    public Car(String _model, int _birth_year, String _type, int _door_count){
        super(_model, _birth_year, _type);
        door_count = _door_count;
    }

    public void drive(){
        System.out.println(super.getModel() + "가 출발하였습니다.");
    }

    public void drive(int speed){
        System.out.println(super.getModel() + "가 " + speed + "km/h의 속도로 운행합니다.");
    }
}
