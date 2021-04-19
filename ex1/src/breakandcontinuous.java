public class breakandcontinuous {
public static void main(String []args){
    int []a={1,2,3,4,5,6,7,8,9};
    System.out.println("in ra vi tri cua so do nao");
    for (int i=0;i<a.length;i++){
        if (a[i]==6){
            System.out.println(i);
            break;
        }
    }
}
    }
//* cau lech break se dung de dung vong lap.
//*cau lech continuous sẽ bỏ qua vòng lặp và thưc hiện vòng lăp tiếp theo.
//*print khong the in ra so va no se không xuống  dong ma viết liền .
//*println cho ket qua se xuong dong