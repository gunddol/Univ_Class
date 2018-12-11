public class Vehicle {
    public String model;
    public int birth_year;
    public String type;

    public Vehicle(String _model, int _birth_year, String _type){
        model = _model;
        birth_year = _birth_year;
        type = _type;
    }

    public String getModel(){
        return model;
    }

    public void drive(){
        System.out.println("Vehicle이 운전을 시작합니다.");
    }
}
