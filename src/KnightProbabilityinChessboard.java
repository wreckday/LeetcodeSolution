import java.util.List;

/**
 * Created by Mellon on 9/30/17.
 */
public class KnightProbabilityinChessboard {

    public static double knightProbability(int N, int K, int r, int c) {
        // dp 記錄現在這個位置剩下k步時, 騎士還有幾種路線還可以走
        double[][][] dp = new double[K + 1][N][N];
        int[][] dir = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int t = 0; t < N; t++) {
                    dp[i][j][t] = -1.0;
                }
            }
        }
        return helper(N, K, r, c, dp, dir);
    }

    public static double helper(int N, int K, int r, int c, double[][][] dp, int[][] dir) {
        if (r < 0 || c < 0 || r >= N || c >= N) return 0;

        if (K == 0) {
            return 1.0;
        }

        if (dp[K][r][c] != -1.0) {
            return dp[K][r][c];
        }

        // 8 directions
        double ans = 0;
        for (int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];
            ans += helper(N, K - 1, x, y, dp, dir);
        }

        dp[K][r][c] = ans / 8;
        return dp[K][r][c];
    }

    public static void main(String[] args) {
        double res = knightProbability(3, 2, 0, 0);
        //double res1 = knightProbability(8, 30, 6, 4);
        System.out.print(res);
    }

}
