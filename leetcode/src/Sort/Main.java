package Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Object{
    public static void main(String[] args) {
        Integer v1 = new Integer(130);
        Integer v2 = v1;
        doS(v2);
        v1 = v2;
        System.out.println(v2.intValue());
        System.out.println(v1.intValue());
    }
    public static void doS(Integer x){
        x = new Integer(149);
    }
}
