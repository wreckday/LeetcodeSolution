/**
 * Created by Mellon on 10/21/17.
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int previousLocalMaxProfit = 0;
            for(int j=0;j<i;j++){
                if(j>0)
                    previousLocalMaxProfit = Math.max(previousLocalMaxProfit, dp[j-1]);

                if(prices[i]-prices[j]>fee){
                    dp[i] = Math.max(dp[i], prices[i]-prices[j]-fee + previousLocalMaxProfit);

                    maxProfit = Math.max(dp[i], maxProfit);

                }
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[] h = {0, Integer.MIN_VALUE + 60000};
        for(int i = 0;i < n;i++){
            int[] nh = new int[2];
            nh[0] = Math.max(h[0], h[1] + prices[i] - fee);
            nh[1] = Math.max(h[1], h[0] - prices[i]);
            h = nh;
        }
        return h[0];
    }

    public static void main(String[] args){
        int[] prices = {1, 3, 2, 8, 4, 9};
        int res = maxProfit(prices, 2);
        System.out.print(res);
    }
}
