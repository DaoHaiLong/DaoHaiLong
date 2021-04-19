import java.util.Scanner;
public class vectorTestDrive {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Nhap so x:");
        int x = scanner.nextInt();
        System.out.println("nhap so y:");
        int y=scanner.nextInt();

        vector L=new vector();
        System.out.println("Sum of two number:"+(x+y));
        L.add();

        System.out.println("Multiple of two number:"+(x*y));
        L.multiply();

        System.out.println("Subtract of two number:"+(x-y));
        L.subtract();
    }
}
