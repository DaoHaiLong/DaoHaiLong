import java.io.FileWriter;
import java.io.IOException;
public class ghifile {

    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("TEN NHAN VIEN:Dao Hai Long\n" +
                    "ID:41\n" +
                    "LUONG CO BAN:5.0E7\n" +
                    "SO GIO TANG CA:50.0\n" +
                    "PHI DI LAI:1000000.0\n" +
                    "PHI BAO HIEM XA HOI:750000.0\n" +
                    "SO TIEN :\n" +
                    "so luong phai dong thue la:4925000.0\n" +
                    "so luong con lai la:4.4325E7\n" +
                    "TEN NHAN VIEN:Doan Dinh Nam\n" +
                    "ID:45\n" +
                    "LUONG CO BAN:5000000.0\n" +
                    "SO GIO TANG CA:100.0\n" +
                    "PHI DI LAI:500000.0\n" +
                    "PHI BAO HIEM XA HOI:750000.0\n" +
                    "SO TIEN :\n" +
                    " so luong dc nhan la:5750000.0");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}