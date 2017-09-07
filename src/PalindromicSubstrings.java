/**
 Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings

 even they consist of same characters.

 Example 1:

 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".

 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 Note:
 The input string length won't exceed 1000.
 *
 * Created by Mellon on 7/22/17.
 */
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;
        boolean[][] dic = new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2||dic[i+1][j-1])) {
                    dic[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        String s = "aaa";
        System.out.print(countSubstrings(s));

    }
}
