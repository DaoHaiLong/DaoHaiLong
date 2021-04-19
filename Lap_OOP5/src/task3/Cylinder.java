package task3;

public class Cylinder extends circle{
    public double calArea() {
        return (2*Math.PI*r*h+2*Math.PI*r*r);
    }

    public double calVolume() {
        this.volume = Math.PI*r*r*h;
        return this.volume;
    }

    public String getName() {

        return ("Cylinder is:");
    }
}
