/**
 * Created by Mellon on 9/13/15.
 */
public class PaintFence {
    public static int numWays(int n, int k) {
        // write your code here
        int[] dp = {k, k*k, 0};
        // dp[2] = (dp[0]+dp[1])*(k-1)
        if(n<=2) return dp[n-1];
        for(int i=2;i<n;i++){
            dp[2] = (dp[0]+dp[1])*(k-1);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    /*

    ＃＃＃思路：
	第一個柱子有k 種顏色可能, 第二根柱子也有k種可能。
	第三根柱子分為三種情況：
	1. 第一根柱子與第三根同色  k*(k-1)*1
	2. 第二根柱子與第三根同色  k*(k-1)*1
	3. 第三根柱子與第一, 二都不同色（又分為兩種情況）：
				1. 第一, 第二同色, 第三跟其他兩根都不同色 k*1*(k-1)
				2. 第一, 第二不同色, 第三跟其他兩根都不同色 k*(k-1)*(k-2)

	全部的可能加起來
	(k-1)(2k + k + k*k-2k) = (k-1)(k+k*k)
 	dp[k] = (dp[k-1]+dp[k-2])*(k-1)


    ＃＃＃時間複雜度： O(n)
    ＃＃＃空間複雜度： O(1)
    ＃＃＃相關題：
    ＃＃＃哪些條件提示我想到了解法：
    * */

    public static void main(String[] args){
        int n = 2;
        int k = 2;
        System.out.println(numWays(n,k));
    }
}
