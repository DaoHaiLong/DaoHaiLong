package task3;

public  class circle extends point {
    public double calVolume() {
        return 0;
    }

    public double calArea() {
        this.area = r*r*Math.PI;
        return this.area;
    }
    @Override
    public String getName() {

        return("circle");
    }
}

