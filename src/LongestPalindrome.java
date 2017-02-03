/**
 * Created by Mellon on 10/1/16.
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] table = new int[256];
        for(int i=0;i<s.length();i++){
            table[s.charAt(i)] = table[s.charAt(i)]+1;
        }

        boolean plusOne = false;
        int res = 0;
        for(int e : table){
            if(e%2!=0) plusOne=true;
            if(e%2!=0){
                res = res + e -1;
            }else{
                res = res + e;
            }
        }

        if(plusOne) res = res +1;
        return res;
    }
    public static void main(String[] args){
        String s = "abccccdd";
        System.out.print(longestPalindrome(s));
    }
}
