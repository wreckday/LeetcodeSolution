import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * Created by Mellon on 4/3/16.
 */
public class CoinChange {
    //O(n*amount) time O(amount) space DP solution
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] count = new int[amount + 1];

        count[0] = 0;
        for (int i = 1; i <= amount; i++) {
            count[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) break;
                count[i] = Math.min(count[i], count[i - coins[j]] + 1);
            }
        }
        return count[amount] > amount ? -1 : count[amount];
    }

    public static void main(String[] args) {
        int[] coins = {3};
        int amount = 2;
        System.out.print(coinChange(coins, amount));
    }
}
