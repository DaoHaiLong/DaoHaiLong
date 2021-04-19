package task3;
import java.util.*;
public class TestShape_INTERFACE {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0].point(5,6);

        shapes[1].circle(5,6, 12 );

        shapes[2].Cylinder(5,2,4, 6);
        for (int i=0;i<=2;i++)
        {
            System.out.println("Name: "+shapes[i].getName());
            System.out.println("Area: "+shapes[i].calArea());
            System.out.println("Volume: "+ shapes[i].calVolume());
        }
}}
