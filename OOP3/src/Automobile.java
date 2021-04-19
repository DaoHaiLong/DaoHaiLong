public class Automobile {
    static double fuel;
    static double speed;
    static String license;
    static void init(double f, double s, String l) {
        fuel = f;
        speed = s;
        license = l;
    }
    static void accelerate(double v) {
        if (fuel > 0) speed += v;
    }
    static void decelerate(double v) {
        if (fuel <= 0) speed -= v;
    }

    public static double getFuel() {
        return fuel;
    }

    public static double getSpeed() {
        return speed;
    }

    public static String getLicense() {
        return license;
    }

    public static void main(String args[]) {
        init(4.5,34,"29JAD");
        System.out.println(getFuel());
        System.out.println("Instantaneous speed: "+getSpeed());
        System.out.println(getLicense());
        accelerate(4);
        System.out.println("Instantaneous speed: "+getSpeed());
        decelerate(5);
        System.out.println("Instantaneous speed: "+getSpeed());
    }
}
