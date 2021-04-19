import java.io.File;  // Import the File class
import java.io.IOException;
public class vi_dufile {
   // Import the IOException class to handle errors

    public static class CreateFile {
        public static void main(String[] args) {
            try {
                File myObj = new File("filename.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

}
