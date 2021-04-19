
import java.util.Scanner;

public class ok{
    public static void main(String[] args) {
        int a,b;
        Scanner sc=new Scanner(System.in);
        System.out.printf("Nhap so a:\n");
        a=sc.nextInt();
        System.out.printf("Nhap so b:\n");
        b=sc.nextInt();
        if (a>b){
            System.out.printf("max=a="+a);
        }
        if (a<b){
            System.out.printf("max=b="+b);
        }
        if (a==b) {
            System.out.printf("hai so bang nhau");
        }
    }

}



