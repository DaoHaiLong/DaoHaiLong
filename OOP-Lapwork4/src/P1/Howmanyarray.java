package P1;

import java.util.Scanner;

public class Howmanyarray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhap kich thuoc:\n");
        int n = scanner.nextInt();
        System.out.println("ket qua cho ra la:");
        if (n == 1) {
            System.out.println(".");
        }
        else    {

            System.out.println("s.");
        }
    }
}
