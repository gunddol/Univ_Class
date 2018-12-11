public class Triangle extends Shape implements Angle{
    public double x;
    public double height;
    static final int edge = 3;

    public Triangle(double _x, double _height){
        super(_x * _height / 2);
        this.x = _x;
        this.height = _height;
    }

    @Override
    public int getEdge() {
        return edge;
    }
}
