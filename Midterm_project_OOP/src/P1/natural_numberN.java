package P1;
import java.util.Scanner;
public class natural_numberN {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=scanner.nextInt();
        if (n<1){
            System.out.println("Stop:");
        }
        if (n>1){
            System.out.println("Number is:"+n);
        }
    }
}
