/**
 Given a string and an integer k, you need to reverse the first k characters
 for every 2k characters counting from the start of the string.
 If there are less than k characters left, reverse all of them.
 If there are less than 2k but greater than or equal to k characters,
 then reverse the first k characters and left the other as original.

 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]

 *
 * Created by Mellon on 3/11/17.
 */
public class ReverseString2 {
    public static String reverseStr(String s, int k) {
        for(int i=0;i<s.length();i=i+2*k){
            s = helper(s, i, i+k-1);
        }

        return s;
    }

    private static String helper(String s, int start, int end){
        char[] s_charArray = s.toCharArray();
        end = Math.min(s.length() - 1, end);
        while(start<end){
            char temp = s_charArray[start];
            s_charArray[start] = s_charArray[end];
            s_charArray[end] = temp;
            start++;
            end--;
        }
        return new String(s_charArray);
    }

    public static void main(String[] args){
        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        String s2 = "abcdefg";


        int k = 39;
        System.out.println(reverseStr(s, k));
    }
}
