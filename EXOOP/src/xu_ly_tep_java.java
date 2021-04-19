//*****************************//
//----****tao tep trong java***-----//
import java.io.File;
import java.io.IOException;

public class xu_ly_tep_java {
    public static class CreateFile {
        public static void main(String[] args) {
            try {
                File myObj = new File("C:\\Users\\long\\filename.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                    System.out.println("Absolute path: " + myObj.getAbsolutePath());
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
//*****************************************//

//----*****ghi vao tep*******----//

//   import java.io.FileWriter;   // Import the FileWriter class
//import java.io.IOException;  // Import the IOException class to handle errors
//
//public class WriteToFile {
//  public static void main(String[] args) {
//    try {
//
//      FileWriter myWriter = new FileWriter("filename.txt");
//      myWriter.write("Files in Java might be tricky, but it is fun enough!");
//      myWriter.close();
//      System.out.println("Successfully wrote to the file.");
//    }
//    catch (IOException e) {
//      System.out.println("An error occurred.");
//      e.printStackTrace();
//    }
//  }
//}

//*****************************************//

//****-**---doc tep****-----***-//

//import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Scanner; // Import the Scanner class to read text files
//
//public class ReadFile {
//  public static void main(String[] args) {
//    try {
//      File myObj = new File("filename.txt");
//      Scanner myReader = new Scanner(myObj);
//      while (myReader.hasNextLine()) {
//        String data = myReader.nextLine();
//        System.out.println(data);
//      }
//      myReader.close();
//    } catch (FileNotFoundException e) {
//      System.out.println("An error occurred.");
//      e.printStackTrace();
//    }
//  }
//}
//*********************************//

//***-------nhan thong tin tep*****----//

//import java.io.File;  // Import the File class
//
//public class GetFileInfo {
//  public static void main(String[] args) {
//    File myObj = new File("filename.txt");
//    if (myObj.exists()) {
//      System.out.println("File name: " + myObj.getName());
//      System.out.println("Absolute path: " + myObj.getAbsolutePath());
//      System.out.println("Writeable: " + myObj.canWrite());
//      System.out.println("Readable " + myObj.canRead());
//      System.out.println("File size in bytes " + myObj.length());
//    } else {
//      System.out.println("The file does not exist.");
//    }
//  }

//***************************************//

//*****---- xoa mot thu muc************///

//import java.io.File;
//
//public class DeleteFolder {
//  public static void main(String[] args) {
//    File myObj = new File("C:\\Users\\MyName\\Test");
//    if (myObj.delete()) {
//      System.out.println("Deleted the folder: " + myObj.getName());
//    } else {
//      System.out.println("Failed to delete the folder.");
//    }
//  }
//}
