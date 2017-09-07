/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 * <p>
 * Created by Mellon on 6/25/16.
 */
public class DecodeWays {
    /*
        ＃＃＃思路：

        這一題是爬樓梯問題的延伸題, 從最後一個字串開始從後往前推,
        如果目前的字跟上一個字聯合起來是小於等於26, 大於0 時, 有兩種可能所以dp[i] = dp[i+1] + dp[i+2];
        如果目前的字跟上一個字聯合起來是大於26, 只有一種可能dp[i] = dp[i+1];

        ＃＃＃時間複雜度： O(n)
        ＃＃＃空間複雜度： O(n)
        ＃＃＃相關題： climbing stairs
        ＃＃＃哪些條件提示我想到了解法：題目說求出所有有幾種方法, 就會想到用dp
    * */
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;   // 90       // 注意這邊跟char '0' 比較不是跟數字比較
        for (int i = n - 2; i >= 0; i--) {
            int str = Integer.parseInt(s.substring(i, i + 2));
            if (s.charAt(i) == '0') {        // 注意這邊跟char '0' 比較不是跟數字比較
                dp[i] = 0;
            } else if (str >= 1 && str <= 26) {   // ex:261 => (B)FA or (Z)A 所以 當0<i<26, dp[i] = dp[i+1]+dp[i+2]
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];     // ex: 351 => (C)EA
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        String code = "1010"; // answer: 1
        String code1 = "110";  // answer:1
        String code2 = "90";  // answer:0
        System.out.println(numDecodings(code1));
    }
}
