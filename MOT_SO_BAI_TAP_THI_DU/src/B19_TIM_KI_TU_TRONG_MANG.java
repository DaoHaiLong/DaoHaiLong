import java.util.Scanner;
public class B19_TIM_KI_TU_TRONG_MANG {
    public static class BaiTapJavaCoBan16
    {
        public static void main(String[] args)
        {
            String chuoi;
            char kiTu;
            boolean tonTai = false;
            Scanner sc = new Scanner(System.in);

            System.out.println("Nhập vào một chuỗi: ");
            chuoi = sc.nextLine();
            System.out.println("Nhập vào ký tự muốn kiểm tra:");
            kiTu = sc.nextLine().charAt(0);

            char[] mangKiTu = chuoi.toCharArray();
            for (char c : mangKiTu) {
                if (kiTu == c) {
                    System.out.println("Có");
                    tonTai = true;
                }
            }
            if(!tonTai)
                System.out.println("Không");
        }
    }
}
// *---------------------luu y-----------------*//
// Phương thức toCharArray() được sử dụng để chuyển đổi chuỗi thành các mảng ký tự. Nó trả về một mảng ký từ có độ dài tương đương độ dài của chuỗi.
// String bản chất cũng giống như một mảng các ký tự,
// để lấy ra ký tự thứ k bên trong String
// bạn có thể dùng phương thức charAt(k - 1);