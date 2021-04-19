import java.util.Scanner;
public class ex {
    private String fullname;
    private int ID;
    private String department;
    private Double basicsalarypermonth;
    private Double overtimehour;
    private Double travelexpenses;
    private Double taxfees =0.1;
    private Double socialnsurance;

    public void thong_tin_nhan_vien(){
      Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap so ID nhan vien:");
        ID= scanner.nextInt();

        System.out.println("Nhap ten nhan vien: ");
        fullname= scanner.nextLine();
        fullname= scanner.nextLine();

        System.out.println("nhap co quan lam viec:");
        department= scanner.nextLine();

        System.out.println("nhap luong co ban:");
        basicsalarypermonth= scanner.nextDouble();

        System.out.println("nhap so gio tang ca:");
        overtimehour= scanner.nextDouble();

        System.out.println("nhap phi di lai:");
        travelexpenses= scanner.nextDouble();

        System.out.println("nhap phi bao hiem xa hoi");
        socialnsurance= scanner.nextDouble();

        //*-------------------------------*//
        System.out.println("hien thong tin la ngoai man hinh:");

        System.out.println("TEN NHAN VIEN:"+fullname);
        System.out.println("ID:"+ID);
        System.out.println("LUONG CO BAN:"+basicsalarypermonth);
        System.out.println("SO GIO TANG CA:"+overtimehour);
        System.out.println("PHI DI LAI:"+travelexpenses);
        System.out.println("PHI BAO HIEM XA HOI:"+socialnsurance);
        System.out.println("SO LUONG DUOC NHAN LA:");

        if ((getBasicsalarypermonth()+getOvertimehour()*20000-getTravelexpenses()-getSocialnsurance())>10000000){
            System.out.println("so luong phai dong thue la:"+(getBasicsalarypermonth()+getOvertimehour()*20000-getTravelexpenses()-getSocialnsurance())*taxfees);
            System.out.println("so luong con lai la:"+((getBasicsalarypermonth()+getOvertimehour()*20000-getTravelexpenses()-getSocialnsurance())-(getBasicsalarypermonth()+getOvertimehour()*20000-getTravelexpenses()-getSocialnsurance())*taxfees));
        }
        else {
            System.out.println(" so luong dc nhan la:"+(getBasicsalarypermonth()+getOvertimehour()*20000-getTravelexpenses()-getSocialnsurance()));
        }

    }

    public Double getBasicsalarypermonth() {
        return basicsalarypermonth;
    }

    public Double getOvertimehour() {
        return overtimehour;
    }

    public Double getSocialnsurance() {
        return socialnsurance;
    }

    public Double getTaxfees() {
        return taxfees;
    }

    public Double getTravelexpenses() {
        return travelexpenses;
    }

    public int getID() {
        return ID;
    }

    public String getDepartment() {
        return department;
    }

    public String getFullname() {
        return fullname;
    }
}
