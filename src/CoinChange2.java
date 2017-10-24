import java.util.*;

/**
 * Created by Mellon on 10/13/17.
 */
public class CoinChange2 {
    //********************************* DP **********
    public int changeDP(int amount, int[] coins) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        int[] dp = new int[amount + 1];

        // Base case (If given value is 0)
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                dp[j]  =  dp[j] + dp[j - coins[i]];

        return dp[amount];
    }

    //********* recursion *******************************************
    public static int changeSimpleRecur(int amount, int[] coins) {
        /*
        count([1, 2, 5], 25) = count([1, 2], 25) + count([5], 20);
            count([1, 2], 25) --- 不包含5, 組成25的所有情況 ＋
            count([5], 20)  --- 至少包含一個5, 組成25(25-5)的所有的情況
        *
        * */

        return count(coins, coins.length, amount);
    }

    // Returns the count of ways we can sum  S[0...m-1] coins to get sum n
    private static int count(int coins[], int m, int n) {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count(coins, m - 1, n) + count(coins, m, n - coins[m - 1]);
    }




    //********************************* 暴力解 ****************************************
    // 跟 combination sum 的做法很像
    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return helper(amount, coins, 0);
    }

    public static int helper(int amount, int[] coins, int start) {
        // base
        if (amount == 0) return 1;
        int total = 0;
        for (int i = start; i < coins.length; i++) {

            if (amount < coins[i]) break;
            total += helper(amount - coins[i], coins, i);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(change(5, coins));
        System.out.println(changeSimpleRecur(5, coins));
    }
}
