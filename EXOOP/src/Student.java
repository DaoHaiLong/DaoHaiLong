public class Student {
    public String name;
    public int age;
    public double height;
    public static String universityName="Kteam educaton";
    public static int total=0;

    public Student(String name,int age,double height){
        this.name=name;
        this.age=age;
        this.height=height;
        total+=1;
    }

    public Student(String aLong, int i, int i1, double v) {
    }

    public static void getinforUniversity() {
        Student.universityName = universityName;
        System.out.println("HowKteam.Free Education");
    }
}
