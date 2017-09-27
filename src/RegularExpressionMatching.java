/**
 * Created by Mellon on 9/26/17.
 */
public class RegularExpressionMatching {


    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        // 1. 先判斷當前的字(第一個字)在text 和 pattern 裡是否一樣？
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        /*
        2. 如果 pattern 的第二個字是 *, 有兩種情況： 因為*可以刪除pattern裡的第一個字, 或者當作很多第一個字。
        如果＊要當作刪除pattern裡的第一個字, 那下個遞迴 pattern 就要變成 pattern.substring(2) 因為要刪除第一個字和＊
        如果＊要當作很多個第一個字, 那麼前提就是pattern 的第一個字和text 的第一個字是一樣的, ＊才可以當作很多第一個字,
        所以下個遞迴text 要刪除第一個字, 也就是從text.substring(1), 因為pattern的第一個字和text的第一個字已經比較過了。

        3. 如果 pattern 的第二個字 不是 *
        那首先先確保第一個字match, 如果match, pattern 和 text 下個遞迴都要從後一個字走

        */
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static boolean isMatchDP(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){


                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));

                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
    /*
    dp time complexity O(Text length * Pattern length)
    * */
    public static void main(String[] args){
        isMatch("aaa", "a*a");
    }
}
