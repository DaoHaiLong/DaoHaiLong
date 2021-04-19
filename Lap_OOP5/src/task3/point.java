package task3;

public class point {
    protected double x,y;
    protected String name;
    protected double r;
    protected double area;
    protected double volume;
    protected double h;


    public double calArea() {
        return 0;
    }

    public double calVolume() {
        return 0;
    }

    public String getName() {
        this.name = "Point ("+x+","+y+")";
        return this.name;
    }

}
