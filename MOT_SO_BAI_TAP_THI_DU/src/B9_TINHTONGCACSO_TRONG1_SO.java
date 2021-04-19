// Viết chương trình tính tổng của các chữ số của môt số nguyên n trong java.
import java.util.Scanner;

public class B9_TINHTONGCACSO_TRONG1_SO {

    /**
     * Chương trình tính tổng của các chữ số của môt số nguyên dương n.
     * Tổng của các chữ số của 6677 là 6 + 6 + 7 + 7 = 26.
     *
     * @author viettuts.vn
     */
    public static class BaiTap12 {
        private static final Scanner scanner = new Scanner(System.in);
        public static int DEC_10 = 10;

        /**
         * main
         *
         * @param args
         */
        public static void main(String[] args) {
            System.out.print("Nhập số nguyên dương n = ");
            int n = scanner.nextInt();
            System.out.printf("Tổng của các chữ số "
                    + "của %d là: %d", n, totalDigitsOfNumber(n));
        }

        /**
         * Tính tổng của các chữ số của một số nguyên dương
         *
         * @param n: số nguyên dương
         * @return
         */
        public static int totalDigitsOfNumber(int n) {
            int total = 0;
            do {
                total = total + n % DEC_10;
                n = n / DEC_10;
            } while (n > 0);
            return total;
        }
    }
}
