public class Sphere extends Shape {
    public double radius;

    public Sphere(double _radius){
        super(_radius * _radius * Math.PI);
        this.radius = _radius;
    }
}
