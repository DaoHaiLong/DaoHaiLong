package P2;
import java.util.Scanner;
public class program {
    private int n;
    private double Englishlistening;
    private double Englishspeaking;
    private double Englishreading;
    private double Englishwriting;
    private String Fullname;
    public void entertheinfo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the n:");
        n=scanner.nextInt();
     for (int i=0;i<n;i++){

         System.out.println("Enter your name["+i+"]:");
         Fullname=scanner.nextLine();
         Fullname=scanner.nextLine();

         System.out.println(" enter the point of listening:["+i+"]");
         Englishlistening=scanner.nextDouble();

         System.out.println("enter the point of reading:["+i+"]");
         Englishreading=scanner.nextDouble();

         System.out.println("enter the point of speaking:["+i+"]");
         Englishspeaking=scanner.nextDouble();

         System.out.println("enter the point of writing:["+i+"]");
         Englishwriting=scanner.nextDouble();


         if ((getEnglishlistening()+getEnglishreading()+getEnglishspeaking()+getEnglishwriting())/4>=10 && getEnglishreading()>=10){
             System.out.println("The English-passing Student");

         }
         else {
             System.out.println("retake");
         }
     }

    }

    public double getEnglishlistening() {
        return Englishlistening;
    }

    public double getEnglishreading() {
        return Englishreading;
    }

    public double getEnglishspeaking() {
        return Englishspeaking;
    }

    public double getEnglishwriting() {
        return Englishwriting;
    }

    public String getFullname() {
        return Fullname;
    }
}
