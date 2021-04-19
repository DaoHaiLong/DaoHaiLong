// -Viết chương trình tìm tất cả các số chia hết
// cho 7 nhưng không phải bội số của 5, nằm trong
// đoạn 10 và 200 (tính cả 10 và 200). Các số thu
// được sẽ được in thành chuỗi trên một dòng, cách
// nhau bằng dấu phẩy.>

import java.util.ArrayList;
import java.util.List;
public class B1_TIMSOCHIAHETCHO7_NOT_5 {

    public static class Bai01 {
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 10; i < 201; i++) {
                if ((i % 7 == 0) && (i % 5 != 0)) {
                    list.add(i);
                }
            }
            // hiển thị list ra màn hình
            showList(list);
        }

        public static void showList(List<Integer> list) {
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size - 1; i++) {
                    System.out.print(list.get(i) + ", ");
                }
                System.out.println(list.get(size - 1));
            }
        }
    }
}
