import java.util.Scanner;
public class oop {
    public static void main(String[] args) {
        person[] b=new person[3];

        System.out.println("ten  va tuoi cua ho la gi:");
        for(int i=0;i< b.length;i++){
           if (i==0){
               b[i]=new person();
               b[i].name="long";
               b[i].age=20;
            }

            if (i==1){
                b[i]=new person();
                b[i].name="huy";
                b[i].age=10;
           }
          if (i==2){
                b[i]=new person();
                b[i].name="vu nhat minh thu";
                b[i].age=5;
           }
        }
        for(int i=0;i< b.length;i++){
            System.out.println(b[i].name);
            System.out.println(b[i].age);
        }
    }
}
