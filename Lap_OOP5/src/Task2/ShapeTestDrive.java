package Task2;
import Task1.*;
public class ShapeTestDrive {
    public static void main(String[] args) {
        Shape[] Long = new Shape[3];
       Long[0] = new Point(1, 2);
       Long[1] = new Circle(1, 3, 3);
       Long[2] = new Cylinder(1, 2, 6, 5);
        for (Shape L : Long) {
            System.out.println(L.getName() + ":");
            System.out.printf("\tArea:\t%.2f\n", L.calArea());
            System.out.printf("\tVolume:\t%.1f\n", L.calVolume());
        }
    }
}

