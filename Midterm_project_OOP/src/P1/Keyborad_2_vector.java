package P1;
import java.util.Scanner;
public class Keyborad_2_vector {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the n:");
        int n=scanner.nextInt();

        float []x=new float[n];
        float []y=new float[n];
        System.out.println(" enter x:");
        for (int i=0;i<n;i++){
            x[i]=scanner.nextFloat();
        }

        System.out.println("enter y:");
        for (int j=0;j<n;j++){
            y[j]=scanner.nextFloat();
        }
        float t=0;
        for (int k=0;k<n;k++){
            t=t+(x[k]-y[k])*(x[k]-y[k]);
            System.out.println("dis:"+ Math.sqrt(t));
        }


    }
}
