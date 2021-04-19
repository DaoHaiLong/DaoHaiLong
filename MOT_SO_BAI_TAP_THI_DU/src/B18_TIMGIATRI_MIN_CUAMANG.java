import java.util.Scanner;
public class B18_TIMGIATRI_MIN_CUAMANG {
    public static class BaiTapJavaCoBan13
    {
        public static void main(String[] args)
        {
            int n;
            int[] soNguyen;
            int min = 0;
            Scanner sc = new Scanner(System.in);

            System.out.println("Nhập vào n:");
            n = sc.nextInt();
            soNguyen = new int[n];
            for (int i = 0; i < n; i++)
            {
                System.out.println("Nhập vào số nguyên:["+i+"]");
                soNguyen[i] = sc.nextInt();
            }

            min = soNguyen[0];

            for (int i = 0; i < n; i++)
            {
                if(soNguyen[i] < min)
                    min = soNguyen[i];
            }

            System.out.println("Phần tử có giá trị nhỏ nhất là: " + min);
        }
    }

}
