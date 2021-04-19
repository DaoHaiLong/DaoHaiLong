
// *---------------------luu y-----------------*//
//-- Phương thức toCharArray() được sử dụng để chuyển đổi chuỗi thành các mảng ký tự.
//  Nó trả về một mảng ký từ có độ dài tương đương độ dài của chuỗi.

//-- String bản chất cũng giống như một mảng các ký tự,
//  để lấy ra ký tự thứ k bên trong String
//  bạn có thể dùng phương thức charAt(k - 1);

//-- Phương thức replace: Phương thức này dùng để thay thế các chuỗi/ký tự được
//  tìm thấy thành chuỗi/ký tự khác.

//-- phuong thuc indexOf: Phương thức này trả về vị trí xuất hiện đầu tiên của một String trong String khác,
//   nếu không tìm thấy thì trả về -1.

//-- Phương thức startsWith và endsWith: Phương thức này dùng để kiểm tra một xâu
//   có bắt đầu hoặc kết thúc băng một xâu khác không.

//--Phương thức split: Phương thức này dùng để tách một xâu ra thành mảng các xâu dựa trên một xâu cho trước

//--Phương thức substring: Đây là phương thức dùng để lấy ra một xâu con dựa trên chỉ số bắt đầu
// và chỉ số kết thúc của một xâu khác.

public class bai_tap_ve_xu_ly_chuoi {

    //--**-- phuong thuc replace:
// import java.util.Scanner;
//
//public class Array {
//	public static void main(String[] args) {
//		System.out.println("Cod3l3arn".replace('3', 'e'));
//		System.out.println("Blackcat".replace("Black", "White"));
//	}
// *****ket qua: Codelearn and Whitecat.
// }

    //  *******************************************

    //--**--Phương thức toUpperCase/toLowerCase:
    //  import java.util.Scanner;

    //  public class Array {
    //      public static void main(String[] args) {
    //        String s = "CoDeLeArN";
    //        System.out.println(s.toUpperCase());
    //        System.out.println(s.toLowerCase());
    //     }
    // *****ket qua: CODELEARN and codelearn.
    // }

    // *******************************************

    //--**-- phuong thuc charAt():

    //import java.util.Scanner;
    //
    //public class Array {
    //	public static void main(String[] args) {
    //		String s = "Code";
    //		System.out.print(s.charAt(2));
    //	}
    //***** ket qua: d
    // }

    //******************************************

    //--**-- phuong thuc tochararray():

    // char[] mangKiTu = chuoi.toCharArray();
    //        for (char c : mangKiTu) {
    //    if (kiTu == c) {
    //        System.out.println("Có");
    //         tonTai = true;
    //    }
    // }
//****** ket qua: có
// }

    //*******************************************

// phuong thuc indexOF:

   // import java.util.Scanner;

 //   public class Array {
  //      public static void main(String[] args) {
 //           String s = "Codelearn";
  //          System.out.println(s.indexOf("learn"));
  //          System.out.println(s.indexOf("black"));
  //      }
  //****** ket qua: 4 and -1
    //  }

    //****************************************

// phuong thuc startswith va endswith:

//import java.util.Scanner;
//
//public class Array {
//	public static void main(String[] args) {
//		String name = "Codelearn";
//		System.out.println(name.startsWith("Code"));
//		System.out.println(name.startsWith("abc"));
//		System.out.println(name.endsWith("rn"));
//		System.out.println(name.endsWith("z"));
//	}
//***** ket qua: true , false ,true ,false.
// }

    //****************************************

 // phuong thuc split:

 //   import java.util.Scanner;

  //  public class Array {
  //      public static void main(String[] args) {
    //        String s = "Welcome to codelearn!";
  //          String[] words = s.split(" ");
  //          for(String word:words) {
  //              System.out.println(word);
  //          }
  //      }
  //******** ket qua:Welcome
    //               to
    //               codelearn!
    //  }

    //*****************************************

// phuong thuc substring:

    //import java.util.Scanner;
    //
    //public class Array {
    //	public static void main(String[] args) {
    //		String name = "Codelearn";
    //		System.out.println(name.substring(0, 2)); bat dau tu vi tri 0 va lay 2 ki tu:
    //		System.out.println(name.substring(0, 4));bat dau tu vi tri 0 va lay 4 ki tu:
    //		System.out.println(name.substring(4)); bat dau tu vi tri 4
    //	}
    //**** ket qua: Co
    //              Code
    //              learn
    // }
// chu y: vi tri ki tu ( bat dau tu 0) khac voi ki tu
}


/// ******** ********** mot co vi du:
// B1:Cho xâu s được nhập và từ bàn phím, bạn hãy viết chương trình đảo ngược xâu s và hiển thị ra màn hình.
// import java.util.Scanner;
//
//public class Array {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s = sc.next();   nhap chuoi array
//		String answer = "";
//		for (int i = s.length() - 1; i >= 0; i--) {
//			answer += s.charAt(i);

//		}   chay tu vi tri ki tu cuoi cung den vi tri dau tien
//		System.out.print(answer);
//	}
//}