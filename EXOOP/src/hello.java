public class hello {
    public static void main(String[] args) {
        Person a=new Person();
        a.name="nam dau bo";
        a.age= 20;
        a.height=1.7;
        a.eat(" rice " );
        int age=a.getAge();
        System.out.println("his age:"+age);
        double height=a.getHeight();
        System.out.println("his height:"+height);

    }
}
