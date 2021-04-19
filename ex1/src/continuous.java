public class continuous {
    public static void main(String []args){
        int []a={1,2,3,4,5,6,7,8,9};
        System.out.println("in ra tong nao:");
        int S=0;
        for (int i:a){
            if (i==5){
                continue;    //* bo qua so 5
            }
            S+=i;
        }
        System.out.print("Total:"+S);
    }
}
//*cau lech continuous sẽ bỏ qua vòng lặp và thưc hiện vòng lăp tiếp theo.