public class Program {
    public static void main(String[] args) {
        Car car = new Car("Avante", 2012, "승용차", 4);
        Airplane airplane = new Airplane("Boeing", 1982, "비행기");
        car.drive();
        airplane.drive();
        car.drive(80);
        airplane.flight();
    }
}
