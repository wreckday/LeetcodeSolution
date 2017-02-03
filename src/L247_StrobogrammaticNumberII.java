import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*
* Created by Mellon on 5/17/16.
*/
public class L247_StrobogrammaticNumberII {
    // 求 n = 5 時, 要用 n = 3 的result 做 concatenate 才能得到n=5 的結果, iterative solution
    public static List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0", "1", "8");
        List<String> two = Arrays.asList("");
        List<String> r = two;

        if(n%2 == 1)
            r = one;

        for(int i=(n%2)+2; i<=n; i+=2){
            List<String> newList = new ArrayList<>();
            for(String str : r){
                if(i != n)
                    newList.add("0" + str + "0");
                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;
    }

    public static void main(String[] args){
        List<String> res = findStrobogrammatic(2);
        Common.printStringList(res);
    }
}
