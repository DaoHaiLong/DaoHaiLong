
import java.util.Scanner;
public class test {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print(" nhap so n:");
            int n = sc.nextInt();
            System.out.println("ok");
        }
        catch( Exception e) {
            System.out.println("Error! ");
        }
        finally {
            System.out.println("done ");
        }
    }
}
