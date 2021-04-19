public class Button {
    private String label;
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void dePress()
    {
        System.out.println("The button "+this.label+" is now being depressed");
    }

    public void unDepress()
    {
        System.out.println("The button "+this.label+" has been undepressed");
    }
}
