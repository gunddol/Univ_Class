public class Program {
    public static void main(String[] args){
        FireEngine fireEngine = new FireEngine();
        Ambulance ambulance = new Ambulance();
        Spark spark = new Spark();
        Motocycle motorcycle = new Motocycle();

        fireEngine.drive();
        fireEngine.printOilType();
        fireEngine.printWheelCount();

        System.out.println("--------");

        ambulance.drive();
        ambulance.printOilType();
        ambulance.printWheelCount();

        System.out.println("--------");

        spark.drive();
        spark.printOilType();
        spark.printWheelCount();

        System.out.println("--------");

        motorcycle.drive();
        motorcycle.printOilType();
        motorcycle.printWheelCount();

        fireEngine.drive("영등포", "왕십리");
    }
}
