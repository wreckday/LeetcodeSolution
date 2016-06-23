/**
 *
 Given a positive integer n,
 find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 * Created by Mellon on 6/12/16.
 */
public class PerfectSquares {
    /*
    First of all, we created the DP array as usual. This DP array stands for the least number of perfect square numbers for its index. For example DP[13]=2 stands for if you want to decompose 13 into some perfect square numbers, it will contains at least two terms which are 33 and 22.

After the initialization of the DP array. We want to iterate through the array to fill all indices. During each iteration we're actually doing this: dp[i] = 1 + min (dp[i-j*j] for j*j<=i). The formula itself is a little bit hard to understand. Here's an example of how it works: (C#)

Suppose we want to get DP[13] and we already have the previous indices filled.

DP[13] = DP[13-1x1]+DP[1] = DP[12]+1 = 3;

DP[13] = DP[13-2x2]+DP[2x2] = DP[9]+1 = 2;

DP[13] = DP[13-3x3] + DP[3x3] = DP[4] + 1 = 2;

We pick the smallest one which is 2 so DP[13] = 2. Hope it helps.
    */


    public static int numSquares(int n) {
        int[] DP = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            int min= Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++)
            {
                min= Math.min(min, DP[i - j * j] + 1);
            }
            DP[i] = min;
        }
        return DP[n];
    }

    public static void main(String[] args){
        System.out.print(numSquares(5));
    }
}
