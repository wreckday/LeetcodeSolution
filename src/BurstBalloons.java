/**
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * Example:
 * <p>
 * Given [3, 1, 5, 8]
 * <p>
 * Return 167
 * <p>
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * <p>
 * Created by Mellon on 3/12/17.
 */
public class BurstBalloons {
    /*
    解题思路：
动态规划（Dynamic Programming）

时间复杂度O(n ^ 3)

参考peisi的答案：https://leetcode.com/discuss/72216/share-some-analysis-and-explanations

以最后被爆破的气球m为界限，把数组分为左右两个子区域

状态转移方程：

dp[l][r] = max(dp[l][r], nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r])
dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；

l与r的跨度k从2开始逐渐增大；

三重循环依次枚举范围跨度k，左边界l，中点m；右边界r = l + k；

具体就是一种思路的转变。
假设[i...j]中以k，作为分割点。先破k。
那么 [i, k] and [k, j] 并不是互相独立的。因为他们之间还可以交际。
但是，如果假设，k是最后一个破裂的，那么， [i, k] and [k, j] 就是互相独立的了。

    * */
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2]; // padding the most left and the most right as 1
        int n = 1;
        for (int x : iNums){
            if (x > 0) nums[n++] = x;
        }
        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];
        // k 是l跟r 的間距
        for (int k = 2; k < n; ++k) {
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m) {
                    dp[l][r] = Math.max(dp[l][r],
                            nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
                    System.out.println(String.format("dp[%1$d][%2$d] = nums[%1$d] * nums[%3$d] * nums[%2$d] + dp[%1$d][%3$d] + dp[%3$d][%2$d]", l, r, m));
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args){
        int[] nums = {3, 1, 5, 8};
        maxCoins(nums);
    }
}
