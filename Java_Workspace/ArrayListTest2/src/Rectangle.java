public class Rectangle extends Shape implements Angle{
    public double x;
    public double y;
    static final int edge = 4;

    public Rectangle(double _x, double _y){
        super(_x * _y);
        this.x = _x;
        this.y = _y;
    }

    @Override
    public int getEdge() {
        return edge;
    }
}
