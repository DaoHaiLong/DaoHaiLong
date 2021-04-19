package src_main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.ArrayIndexOutOfBoundsException;
public class lec1 {
    private static Object OptType;

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        // add element
        lst.add(33);
        lst.add(2021);
        Integer e = lst.get(0);
        e=e+2;
        // check out
        if (lst.contains(2021)){
            System.out.println("happy new year");
        }
        System.out.println(lst);
        // linklist String
        List<String>lst2=new LinkedList<>();
        // add String
        lst2.add("Hello!");
        lst2.add("Dao Hai Long");
        System.out.println(lst2);
    }
}