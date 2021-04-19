public class Person {
    public String name;
    public int age;
    public double height;
    public Person(){
        this.name=name;
        this.age=age;
        this.height=height;
    }
    public void eat(String foodname){
        System.out.println(name+" is eating"+foodname);
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}
