/**
 * Created by Mellon on 3/1/15.
 *
     Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit.
     You may complete as many transactions as you like
     (ie, buy one and sell one share of the stock multiple times).
     However, you may not engage in multiple transactions at the same time
     (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int local=0;
        int global=0;
        for(int i=1;i<prices.length;i++){
            local = Math.max(local+prices[i]-prices[i-1], local);
            global = Math.max(local, global);
        }
        return global;
    }
}
