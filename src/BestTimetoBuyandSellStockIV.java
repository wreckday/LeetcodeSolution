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
        // write your code here
        if (k == 0) {
            return 0;
        }
        // can treat as unlimited transaction, refer to BestTimetoBuyandSellStockII
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int n = prices.length;
        int[][] mustSell = new int[n + 1][n + 1];   // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalBest = new int[n + 1][n + 1];  // globalBest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益

        mustSell[0][0] = globalBest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustSell[0][i] = globalBest[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int gainorLose = prices[i] - prices[i - 1];
            mustSell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustSell[i][j] = Math.max(globalBest[(i - 1)][j - 1] + gainorLose, mustSell[(i - 1)][j] + gainorLose);
                globalBest[i][j] = Math.max(globalBest[(i - 1)][j], mustSell[i][j]);
            }
        }
        return globalBest[(n - 1)][k];
    }

    public static void main(String[] args){
        int[] prices1={5,-2,3,4,1,9};
        int k = 3;
        System.out.println(maxProfit(k, prices1));
    }
}
