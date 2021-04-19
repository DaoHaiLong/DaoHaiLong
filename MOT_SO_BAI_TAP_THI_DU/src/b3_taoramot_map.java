//Hãy viết chương trình để tạo ra một map chứa (i, i*i), trong đó i là số nguyên từ 1 đến n
// (bao gồm cả 1 và n), n được nhập từ bàn phím.>
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class b3_taoramot_map {
    public static class Bai03 {
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.print("Nhập số nguyên dương n = ");
            int n = scanner.nextInt();

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 1; i < n + 1; i++) {
                map.put(i, i * i);
            }
            System.out.println(map);
        }
    }
}
