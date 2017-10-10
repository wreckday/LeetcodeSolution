/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * <p>
 * Created by Mellon on 10/9/17.
 */
public class EditDistance {
    /*
    dp[i][j] to be the minimum number of operations to convert word1[0..i - 1] to word2[0..j - 1]
    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
    */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // initiate base case remove character in s1 to match emptyString of s2
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;

        // initiate base case remove character in s2 to match emptyString of s1
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else { // 對稱的 insert in s1 等於 remove from s2
                    int insertCharacterToS1_eqaulsToRemoveCharacterInS2 = dp[i][j - 1];
                    int RemoveCharacterInS1_eqaulsToInsertCharacterToS2 = dp[i - 1][j];
                    int replaceCharacterInS1 = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insertCharacterToS1_eqaulsToRemoveCharacterInS2 + 1,
                            Math.min(RemoveCharacterInS1_eqaulsToInsertCharacterToS2 + 1, replaceCharacterInS1 + 1));
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        System.out.println(minDistance(s1, s2));

    }
}
