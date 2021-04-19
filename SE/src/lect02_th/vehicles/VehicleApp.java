package src.lect02_th.vehicles;

/**
 * @overview A test application for vehicles.
 * length(restre)=12
 * @author dmle
 */
public abstract class VehicleApp {
    public VehicleApp(String n, double d, double h, double l, double w, int c) {

    }
    public String name;
    public double width;
    public double heigth;
    public  String register;
    public  double capacity;

    public static void main(String[] args) {
        // create objects
        VehicleApp v1 = new Bus("b1",3.0,3.0,10.0,6000,40);
        VehicleApp v2 = new Car("c1",1.5,1.5,2.5,1500,4);
        // use objects
        System.out.println("Vehicle " + v1.getName() + 
            ", weight: " + v1.calcTotalWeight());
        System.out.println("Vehicle " + v2.getName() + 
            ", weight: " + v2.calcTotalWeight());
    }

    private String calcTotalWeight() {
        return calcTotalWeight();
    }

    String getName() {
        return  getName();
    }

    @utils.DomainConstraint(type="Double",min= Bus.MIN_WEIGHT,optional=false)
    protected abstract boolean validateWeight(double w);

    @utils.DomainConstraint(type="Integer",min= Bus.MIN_SEATCAP,optional=false)
    protected abstract boolean validateSeatingCapacity(int c);
    public  void getsymbol(int A, int B){
        int dis =B-A;
        String symbol;
        symbol = getsymbol();

    }

    protected abstract String getsymbol();

    protected String symbol(){
        return null;
    }
}
