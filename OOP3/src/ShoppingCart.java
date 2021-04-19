import java.util.Scanner;
public class ShoppingCart {
    private String[] cartContents;
    int i=0;

    public void addToCart(String name)
    {
        if (this.cartContents == null) {
            this.cartContents = new String[100];
        }
        this.cartContents[i] = name;
        i++;
    }
    public void removeFromCart(String name)
    {
        int h=1000;
        int j=0;
        while (j<=i)
        {
            if (name.equals(cartContents[j]))
            {
                h=j;
                break;
            }
            else
            {
                j++;
            }
        }
        if (h==1000)
        {
            System.out.println("There is no such thing in the cart");
        }
        else {
            for (int m = h; m < i; m++) {
                this.cartContents[m] = this.cartContents[m + 1];
            }
        }

    }
    public void checkOut()
    {
        System.out.println("For now, the cart has: ");
        for (int k=0;k<=100;k++)
        {
            System.out.println(" "+ this.cartContents[k]);
            if (this.cartContents[k+1]==null)
            {
                break;
            }
        }
    }
}
