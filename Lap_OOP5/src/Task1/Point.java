package Task1;

public class Point extends Shape {
    double X,Y;
    public Point(double X,double Y){
        this.X=X;
        this.Y=Y;
    }

    @Override
    public String getName() {
        return "Point";
    }

}
