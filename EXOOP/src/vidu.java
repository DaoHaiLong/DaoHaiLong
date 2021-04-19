import java.util.Scanner;
public class vidu {
    public static class Method {
        public static void show(int[] arr) {
            for (int i: arr) {
                if (i % 3 == 0 && i % 5 != 0) {
                    System.out.println("ket qua:");
                    System.out.println(i + " ");
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print(" nhap so n:");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("nhap array:["+i+"]");
                arr[i] = sc.nextInt();

            }
            show(arr);
        }
    }
}

