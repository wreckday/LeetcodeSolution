/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Created by Mellon on 9/29/16.
 */
public class BestTimetoBuyandSellStockIV {

    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        if (len < 2 || k <= 0)
            return 0;

        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);

                //System.out.println(String.format("local[%1$d][%2$d] : %3$d", i, j, local[i][j]));
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                //System.out.println(String.format("global[%1$d][%2$d] : %3$d", i, j, global[i][j]));
            }
        }

        return global[prices.length - 1][k];
    }

    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    /*
    Analysis O(nk) solution with O(k) space

    This is a generalized version of Best Time to Buy and Sell Stock III.
    If we can solve this problem, we can also use k=2 to solve III.

    The problem can be solve by using dynamic programming. The relation is:

    local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
    global[i][j] = max(local[i][j], global[i-1][j])

    We track two arrays - local and global.
    1. The local array tracks maximum profit of j transactions and the last transaction is on ith day.
    2. The global array tracks the maximum profit of at most j transactions until ith day.
    * */

    public static void main(String[] args){
        int[] prices1={6,1,3,2,4,7};
        int k = 2;   // expected : 7
        System.out.println("_______________________");
        System.out.println("answer: " + maxProfit(k, prices1));
    }
}
