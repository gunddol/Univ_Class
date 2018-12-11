import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program{
    public static void main(String[] args){
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        shapes.add(new Rectangle(3.5, 4.5));
        shapes.add(new Triangle(2.5, 5.2));
        shapes.add(new Sphere(3.3));
        shapes.add(new Sphere(2.1));

        shapes = arraySortAsOfKinds(shapes);
        printArray(shapes);

        shapes = arraySortAsOfArea(shapes);
        printArray(shapes);
    }

    private static ArrayList<Shape> arraySortAsOfArea(ArrayList<Shape> shapes) {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if((int)o1.getArea() < (int)o2.getArea()) return -1;
                else return 1;
            }
        });

        System.out.println("넓이 기준 정렬");
        return shapes;
    }

    private static ArrayList<Shape> arraySortAsOfKinds(ArrayList<Shape> shapes){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1 instanceof Sphere && o2 instanceof Sphere){
                    if((int)((Sphere) o1).radius < (int)((Sphere) o2).radius) return -1;
                    else return 1;
                }else if(!(o1 instanceof Sphere) && !(o2 instanceof Sphere)){
                    if(o1 instanceof Triangle) return -1;
                    else return 1;
                }else{
                    if(o1 instanceof Sphere) return -1;
                    else return 1;
                }
            }
        });

        System.out.println("모양 기준 정렬 : 원형 -> 삼각형 -> 사각형" + "\n" + "같은 원형끼리는 반지름 기준 오름차순");
        return shapes;
    }

    private static void printArray(ArrayList<Shape> shapes){
        int cnt = 1;
        for(Shape i : shapes){
            System.out.println(cnt + "번째 도형");

            if(i instanceof Sphere){
                System.out.println("Sphere");
                System.out.println("Radius : " + ((Sphere) i).radius);
                System.out.println("Area : " + i.getArea());
            }
            else if(i instanceof Rectangle) {
                System.out.println("Rectangle");
                System.out.println("X : " + ((Rectangle) i).x);
                System.out.println("Y : " + ((Rectangle) i).y);
                System.out.println("Edge : " + ((Rectangle) i).getEdge());
                System.out.println("Area : " + i.getArea());
            }
            else {
                System.out.println("Triangle");
                System.out.println("X : " + ((Triangle) i).x);
                System.out.println("Height : " + ((Triangle) i).height);
                System.out.println("Edge : " + ((Triangle) i).getEdge());
                System.out.println("Area : " + i.getArea());
            }
            System.out.println("-----------------");
            cnt++;
        }
    }
}
