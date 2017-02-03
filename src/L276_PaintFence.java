/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.
 *
 * Created by Mellon on 5/13/16.
 */
public class L276_PaintFence {
    /*
    There can be multiple 2 adjacent posts have same colors--a more clear way to put it is "no 3 adjacent posts have the same color"

for 4 post 2 color case (0 for black, 1 for red)
0011 is a valid solution,
0001 is not
思路
这种给定一个规则，计算有多少种结果的题目一般都是动态规划，
因为我们可以从这个规则中得到递推式。
根据题意，不能有超过连续两根柱子是一个颜色，
也就意味着第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色。
如果不是同一个颜色，计算可能性的时候就要去掉之前的颜色，也就是k-1种可能性。
假设dp[1]是第一根柱子及之前涂色的可能性数量，
dp[2]是第二根柱子及之前涂色的可能性数量，
则dp[3]=(k-1)*dp[1] + (k-1)*dp[2]。

递推式有了，下面再讨论下base情况，所有柱子中第一根涂色的方式有k中，第二根涂色的方式则是k*k，因为第二根柱子可以和第一根一样。
    * */
    public int numWays2(int n, int k) {
        // 当n=0时返回0
        int dp[] = {0, k , k*k, 0};
        if(n <= 2){
            return dp[n];
        }
        for(int i = 2; i < n; i++){
            // 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
    /*
    for f3, there are two situations,
    1.  f1 has the same color with f2, f3 will be k*1*(k-1).
    2.  f1 has the different color with f2, f3 will be k*(k-1)*k
    so we can get f3 = (k-1)(k+k2) => f3 = (k-1)(dp[1]*dp[2])
    * */
}
