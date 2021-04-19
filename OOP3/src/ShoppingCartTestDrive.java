public class ShoppingCartTestDrive {
    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addToCart("Ice cream");
        sc.addToCart("Snack");
        sc.addToCart("Bread");
        sc.addToCart("Fish");
        sc.addToCart("Fruit");
        sc.addToCart("Cheese");
        sc.addToCart("Pizza");

        sc.checkOut();
        sc.removeFromCart("Fish");
        sc.checkOut();
        sc.removeFromCart("Pizza");
        sc.checkOut();
        sc.removeFromCart("Meo");
    }
}
