package P1;
import java.util.Scanner;
public class Transpose {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("hay nhap kich thuc array:");
        int n= scanner.nextInt();
        int[][] L=new int[n][n];

//*---------- khoi tao array-----------*//
        for (int i = 0; i < n; i ++){
            for (int j=0; j<n;j++){
                System.out.println("Nhập arr["+ i +"][" + j +"] = ");
                L[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Before");
        System.out.println("-----------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", L[i][j]);
            }
            System.out.println();
        }

       //* ------Transpose array-------*//
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                int term=L[i][j];
                L[i][j]=L[j][i];
                L[j][i]=term;
            }
        }
        //*-------------print to the screen :----*//
        System.out.println();
        System.out.println("After");
        System.out.println("-----------");

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.printf("%4d", L[i][j]);
            }
        }
        System.out.println();
  }
}
