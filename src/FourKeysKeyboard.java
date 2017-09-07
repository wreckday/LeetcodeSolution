/**
 * Created by Mellon on 8/3/17.
 */
public class FourKeysKeyboard {
/*
    We use i steps to reach maxA(i) then use the remaining n - i steps to reach n - i - 1 copies of maxA(i)

    For example:
    A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
    Here we have n = 7 and we used i = 3 steps to reach AAA
    Then we use the remaining n - i = 4 steps: Ctrl A, Ctrl C, Ctrl V, Ctrl V, to reach n - i - 1 = 3 copies of AAA

    We either don't make copies at all, in which case the answer is just n, or if we want to make copies, we need to have 3 steps reserved for Ctrl A, Ctrl C, Ctrl V so i can be at most n - 3

    public int maxA(int n) {
        int max = n;
        for (int i = 1; i <= n - 3; i++)
            max = Math.max(max, maxA(i) * (n - i - 1));
        return max;
    }
    Now making it a DP where dp[i] is the solution to sub-problem maxA(i)
    time complexity : O(N2)
*/
    public int maxA(int n) {
        /*
        when i=7 and j=1, dp[1](A) than do Ctrl A (Step2), Ctrl C(Step3), CtrlV(Step4), CtrlV(Step5), CtrlV(Step6), CtrlV(Step7)=> A A A A A dp[7] = 4
        when i=7 and j=2, dp[2](AA) than do Ctrl A (Step3), Ctrl C(Step4), CtrlV(Step5), CtrlV(Step6), CtrlV(Step7)=> AA AA AA AA dp[7] = 8
        when i=7 and j=3, dp[3](AAA) than do Ctrl A (Step4), Ctrl C(Step5), CtrlV(Step6), CtrlV(Step7)=> AAA AAA AAA dp[7] = 9
        when i=7 and j=4, dp[4](AAAA) than do Ctrl A (Step5), Ctrl C(Step6), CtrlV(Step7)=> AAAA AAAA dp[7] = 8
        * */
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }
}
