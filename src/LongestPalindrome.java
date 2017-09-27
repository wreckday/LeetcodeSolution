/**
 * Created by Mellon on 10/1/16.
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        // write your code here
        // 找可能出現palindrom 的間隔 或字
        if(s == null || s.length()==0) return s;
        int max = 0;
        String res = "";
        for(int i=0;i<2*s.length();i++){
            int left = i/2;
            int right = i/2;
            if(i%2==1){
                right++;
            }
            String cur = helper(left, right, s);
            if(cur.length() >= max){
                max = cur.length();
                res = cur;
            }
        }
        return res;
    }
    // find the longest palindrome
    private static String helper(int left, int right, String s){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    //*************************** DP 解法
    // time: O(n2)
    // space: O(n2)
    public String longestPalindrome_DP(String s) {
        if(s == null || s.length()==0) return s;
        int max = 0;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length()-1;i>=0;i--){
            for(int j = i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j-i+1 >= max) {
                        max = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args){
        String s = "abccccdd";
        System.out.print(longestPalindrome(s));
    }
}
