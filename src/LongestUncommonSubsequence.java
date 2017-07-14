import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Created by Mellon on 4/1/17.
 */
public class LongestUncommonSubsequence {


    public static void main(String[] args){
        int res2 = findLUSlength("abc","ab");
        System.out.println(res2);
    }

    public static int findLUSlength(String a, String b) {
        if(a == null || b==null ) return -1;
        if(a.equals(b)) return -1;

        return Math.max(a.length(), b.length());
    }
}
