package P1;
import java.util.Scanner;
public class thereversesproblem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("hay nhap kich thuoc array vao:");
        int arraySize=scanner.nextInt();
        double[] a=new double[arraySize];

///* khoi tao array
        for (int i = 0; i < arraySize; i ++){
            System.out.print("nhap array [" + i +"] =" );
            a[i] = scanner.nextDouble();
        }

        for (int i=0; i<arraySize/2;i++){
             double term=a[arraySize-i-1];
             a[arraySize-i-1]=a[i];
             a[i]=term;

        }
        System.out.println(" new String:");
        for (int k=0; k<arraySize;k++){
            System.out.println(a[k]);
        }
    }
}
