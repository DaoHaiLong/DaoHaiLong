import java.util.Scanner;
public class B17_TIMGIATRI_MAX_CUAMANG {

    public static class BaiTapJavaCoBan12
    {
        public static void main(String[] args)
        {
            int n;
            int[] soNguyen;
            int max = 0;
            Scanner sc = new Scanner(System.in);

            System.out.println("Nhập vào n:");
            n = sc.nextInt();
            soNguyen = new int[n];
            for (int i = 0; i < n; i++)
            {
                System.out.println("Nhập vào số nguyên:["+i+"]");
                soNguyen[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++)
            {
                if(soNguyen[i] > max)
                    max = soNguyen[i];
            }

            System.out.println("Phần tử có giá trị lớn nhất là: " + max);
        }
    }
}
