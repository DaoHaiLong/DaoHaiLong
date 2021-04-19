package P1;

public class HugeArray {

    public static void main(String[] args) {
        int n = 1000;
        int[] a = new int[n*n*n*n];
        System.out.println(a.length);
    }
}
//* ---------- problem ----------*//
//*------ Since n is very largest-----*//
//*------- Fix problem------**//
//*------- exchange x=1000 to the number smaller than 1000.EX x=20 ------**//