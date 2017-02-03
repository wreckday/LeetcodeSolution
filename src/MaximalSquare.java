/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 * <p>
 * Created by Mellon on 10/7/16.
 */
public class MaximalSquare {
//    Time Complexity: O(m*n) where m is number of rows and n is number of columns in the given matrix.
//    Auxiliary Space: O(m*n) where m is number of rows and n is number of columns in the given matrix.
    public int maximalSquare(char[][] a) {
        if (a.length == 0) return 0;
        int m = a.length;
        int n = a[0].length;
        int result = 0;

        int[][] b = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result * result;
    }
}
