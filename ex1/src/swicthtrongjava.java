import java.util.Scanner;
public class swicthtrongjava {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("hay nhap thang vao nao:");
        int thang;
        thang=sc.nextInt();

     System.out.println("In ra so ngay cua thang nao:");
       switch (thang){
           case 1:
           case 3:
           case 5:
           case 7:
           case 8:
           case 10:
           case 12:
               System.out.println(" thang co 31 ngay");
               break;
           case 4:
           case 6:
           case 9:
           case 11:
               System.out.println("thang co 30 ngay");
               break;
           case 2:
               System.out.println("thang co 28 ngay");
               break;
           default:
               System.out.println("day la nam 2020");

       }

        System.out.println("event:" + thang);
    }
}
