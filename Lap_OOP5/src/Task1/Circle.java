package Task1;
public class Circle extends Point {
    double r;
    public Circle(double X, double Y, double r) {
        super(X, Y);
        this.r = r;
    }

    @Override
    public double calArea() {
        return (Math.PI * r * r);
    }

    @Override
    public String getName() {
        return "circle";
    }
}
