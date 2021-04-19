package Task1;
public class Cylinder extends Circle {
    double h;
    public Cylinder(double X, double Y, double r, double h) {
        super(X, Y, r);
        this.h = h;
    }

    @Override
    public double calArea() {
        return (2 * Math.PI * r* h + 2 *Math.PI * r * r);
    }

    @Override
    public double calVolume() {
        return (2 * Math.PI * r * r* h);
    }

    @Override
    public String getName() {
        return "cylinder";
    }
}
