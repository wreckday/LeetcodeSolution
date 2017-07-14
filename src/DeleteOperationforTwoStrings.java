/**
 Given two words word1 and word2,
 find the minimum number of steps required to make word1 and word2 the same,
 where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.
 *
 * Created by Mellon on 5/13/17.
 */
public class DeleteOperationforTwoStrings {
    public static int minDistance(String word1, String word2) {
        int subSize = longestCommonSubstring(word1, word2);
        return word1.length()-subSize+word2.length()-subSize;
    }

    public static int longestCommonSubstring(String A, String B) {
        // state: f[i][j] is the length of the longest lcs
        // ended with A[i - 1] & B[j - 1] in A[0..i-1] & B[0..j-1]
        int n = A.length();
        int m = B.length();
        int[][] f = new int[n + 1][m + 1];

        // initialize: f[i][j] is 0 by default

        // function: f[i][j] = f[i - 1][j - 1] + 1 or 0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
            }
        }

        // answer: max{f[i][j]}
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, f[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String str1 = "park";
        String str2 = "spake";
        int res = minDistance(str1, str2);
        // expected res = 3
        System.out.print(res);
    }
}
