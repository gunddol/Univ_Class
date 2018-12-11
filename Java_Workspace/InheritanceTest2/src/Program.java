public class Program {
    public static void main(String[] args){
        Object[] objects = new Object[5];
        objects = randomCar(objects);
        printCars(objects);
    }

    public static Object[] randomCar(Object[] objects){
        int i;
        int mathRandomInt;

        for(i=0;i<objects.length;i++){
            mathRandomInt = (int) (Math.random() * 100);
            if(mathRandomInt % 2 == 0){
                Avante a = new Avante();
                objects[i] = a;
            }else{
                Sonata a = new Sonata();
                objects[i] = a;
            }
        }

        return objects;
    }

    public static void printCars(Object[] objects){
        int i;

        for(i=0;i<objects.length;i++){
            if(objects[i] instanceof Avante){
                System.out.println(i+1 + "번째 차는 아반떼입니다.");
            }else{
                System.out.println(i+1 + "번째 차는 소나타입니다.");
            }
        }
    }
}
