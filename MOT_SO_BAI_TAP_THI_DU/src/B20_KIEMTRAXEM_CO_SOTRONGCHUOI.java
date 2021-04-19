import java.util.Scanner;
public class B20_KIEMTRAXEM_CO_SOTRONGCHUOI {
    public static class BaiTapJavaCoBan18
    {
        public static void main(String[] args)
        {
            String chuoi;
            Scanner sc = new Scanner(System.in);

            System.out.println("Nhập vào một chuỗi: ");
            chuoi = sc.nextLine();
            System.out.println("ket qua:");
            if (chuoi.matches(".*\\d.*"))
                System.out.println("Có");
            else
                System.out.println("Không");
        }
    }
}
