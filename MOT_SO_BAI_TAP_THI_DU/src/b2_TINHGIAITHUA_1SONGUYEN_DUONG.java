
//Viết một chương trình tính giai thừa của một số nguyên dương n.
// Với n được nhập từ bàn phím>
import java.util.Scanner;
public class b2_TINHGIAITHUA_1SONGUYEN_DUONG {

    public static class GiaiThuaDemo2 {
        private static final Scanner scanner = new Scanner(System.in);
        /**
         * main
         *
         * @author viettuts.vn
         * @param args
         */
        public static void main(String[] args) {
            System.out.print("Nhập số nguyên dương n = ");
            int n = scanner.nextInt();
            System.out.println("Giai thừa của " + n + " là: " + tinhGiaithua(n));
        }

        /**
         * tinh giai thua
         *
         * @author viettuts.vn
         * @param n: so nguyen duong
         * @return giai thua cua so n
         */
        public static long tinhGiaithua(int n) {
            if (n > 0) {
                return n * tinhGiaithua(n - 1);
            } else {
                return 1;
            }
        }
    }
}
