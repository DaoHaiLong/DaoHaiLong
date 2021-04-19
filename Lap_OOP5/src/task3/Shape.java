package task3;

public interface Shape {
    public abstract void point(int x, int y);
    public abstract void circle(int x, int y, int r);
    public abstract void Cylinder(int x, int y, int r, int h);
    public abstract void setName(String name);

    public abstract double calArea();

    public abstract double calVolume();

    public abstract String getName();
}
