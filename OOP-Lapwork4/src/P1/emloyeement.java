package P1;
import java.util.Scanner;
public class emloyeement {
    private int EmployeeID;
    private double Basicsalary;
    private double Extrasalary;
    private String Employeedepartment;
    private String Employeefullname;


    public void nhapthongtin(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Nhap ID:");
        EmployeeID=scanner.nextInt();

        System.out.println("Nhap full name: ");
        Employeefullname=scanner.nextLine();
        Employeefullname=scanner.nextLine();

        System.out.println("Nhap department:");
        Employeedepartment=scanner.nextLine();

        System.out.println("nhap luong co ban:");
        Basicsalary=scanner.nextDouble();

        System.out.println(" nhap Extrasalary:");
        Extrasalary=scanner.nextDouble();

        System.out.println("ket qua:"+(getBasicsalary()+ getExtrasalary()*2.5));

        System.out.println("HIen thong tin ra man hinh");
        System.out.println("*******************");

        System.out.println("ID nhan vien " + EmployeeID);
        System.out.println("ho ten nhan vien: " + Employeefullname);
        System.out.println("Noi nhan vien cong tac:  " + Employeedepartment);
        System.out.println("luong co ban:" + Basicsalary);
        System.out.println("extrasalary: " + Extrasalary);

    }

    public int getEmployeeID(){
        return this.EmployeeID;
    }

    public double getBasicsalary() {
        return this.Basicsalary;
    }

    public double getExtrasalary() {
        return this.Extrasalary;
    }

    public String getEmployeefullname() {
        return this.Employeefullname;
    }

    public String getEmployeedepartment() {
     return this.Employeedepartment ;
    }


}
