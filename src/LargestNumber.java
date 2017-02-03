import java.util.Arrays;
import java.util.Comparator;

/**
 Given a list of non negative integers, arrange them such that they form the largest number.
 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Created by Mellon on 9/29/16.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        // 1. transfer int[] to string []
        String[] numStrArray = new String[num.length];

        for (int i = 0; i < num.length; i++) {
            numStrArray[i] = String.valueOf(num[i]);
        }

        // 2. customize sort string
        Arrays.sort(numStrArray, new Comparator<String>() {
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        });

        // 3. concatinate string array to a string
        StringBuilder sb = new StringBuilder();
        for(String s:numStrArray){
            sb.append(s);
        }

        // 4. prevent {0,0} case ==> 00
        if(sb.charAt(0) == '0')
            return "0";

        return sb.toString();
    }
}
