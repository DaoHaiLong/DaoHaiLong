public class ButtonTestDrive {
    public static void main(String[] args) {
        Button L = new Button();
        L.setColor("red");
        L.setLabel("Self-Destruct");
        System.out.println(L.getColor());
        System.out.println(L.getLabel());
        L.dePress();
        L.unDepress();
    }
}
