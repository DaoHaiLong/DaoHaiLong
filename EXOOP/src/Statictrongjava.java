public class Statictrongjava {
    public static void main(String[] args) {
        Student a=new Student("Chau",21,1.7);
        System.out.println("University(from class): "+Student.universityName);
        System.out.println("University(from class) :"+a.universityName);

        System.out.println("Total(from class)"+Student.total);
        Student b=new Student("Long",21,1,1.75);
        System.out.println("Total(from instance)"+b.total);


    }
}
//*---- Static: khai bao bien tinh,bien do co the luu thong tin chung cho tat ca doi tuong--//
//-- tao phuong thuc tinh:Giong nhu bien tinh,co the goi ma khong can khoi tao doi tuong.Tuy nhien
// phuong thuc static khong the tac dong dien thuoc tin va phuong thuc lien quan doi voi doi tuong (non-static)>
//- public static void get..
//-khoi static: dung de tao cac gia tri static, se dc thuc hien khi lop chua no dc load vao bo nho>

//Ex:

//-public class along{
 //   static String course;
//    static {
//        System.out.println("Howkteam");
//        course="java course free";

//    }

  //     public static void main(String[] args) {
   //        System.out.println("Free education:");
 //         System.out.println("course:"+along.course);
    //    }
///      }