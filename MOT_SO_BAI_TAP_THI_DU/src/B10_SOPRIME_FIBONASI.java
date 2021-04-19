//Viết chương trình liệt kê các số Fibonacci nhỏ hơn n
// là số nguyên tố trong java. N là số nguyên dương
// được nhập từ bàn phím.>
import java.util.Scanner;
public class B10_SOPRIME_FIBONASI {

    /**
     *  Chương trình liệt kê các số Fibonacci nhỏ hơn n là số nguyên tố.
     *  Với n được nhập từ bàn phím.
     *
     * @author viettuts.vn
     */
    public static class BaiTap14 {
        private static final Scanner scanner = new Scanner(System.in);
        /**
         * main
         *
         * @param args
         */
        public static void main(String[] args) {
            System.out.print("Nhập số tự nhiên n = ");
            int n = scanner.nextInt();

            System.out.printf("Các số fibonacci nhỏ hơn %d và " + "là số nguyên tố: ", n);

            int i = 0;
            while (fibonacci(i) < n) {
                int fi = fibonacci(i);
                if (isPrimeNumber(fi)) {
                    System.out.print(fi + " ");
                }
                i++;
            }
        }

        /**
         * Tính số fibonacci thứ n
         *
         * @param n: chỉ số của số fibonacci tính từ 0
         *           vd: F0 = 0, F1 = 1, F2 = 1, F3 = 2
         * @return số fibonacci thứ n
         */
        public static int fibonacci(int n) {
            if (n < 0) {
                return -1;
            } else if (n == 0 || n == 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

        /**
         * check so nguyen to
         *
         * @author viettuts.vn
         * @param n: so nguyen duong
         * @return true la so nguyen so,
         *         false khong la so nguyen to
         */
        public static boolean isPrimeNumber(int n) {
            // so nguyen n < 2 khong phai la so nguyen to
            if (n < 2) {
                return false;
            }
            // check so nguyen to khi n >= 2
            int squareRoot = (int) Math.sqrt(n);
            for (int i = 2; i <= squareRoot; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
