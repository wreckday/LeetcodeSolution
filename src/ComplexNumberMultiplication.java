import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Mellon on 3/25/17.
 */
public class ComplexNumberMultiplication {
    public static String complexNumberMultiply(String a, String b) {
        int x = a.indexOf('+');
        int a1 = Integer.parseInt(a.substring(0, x));
        int b1 = Integer.parseInt(a.substring(x+1, a.length()-1));

        int y = b.indexOf('+');
        int a2 = Integer.parseInt(b.substring(0, y));
        int b2 = Integer.parseInt(b.substring(y + 1, b.length()-1));

        int first = a1*a2-b1*b2;
        int second = a1*b2+b1*a2;
        String firstS = String.valueOf(first);
        String secondS = String.valueOf(second);
        return firstS + "+" + secondS + "i";
    }



    public static void main(String[] args){
        //int test = Integer.parseInt("-1");
        String s1 = "78+-76i";
        String s2 = "-86+72i";
        System.out.print(complexNumberMultiply(s1, s2));
    }
}
