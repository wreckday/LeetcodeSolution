import java.util.Arrays;

/**
 * Created by Mellon on 8/2/15.
 */
public class MinimumSizeSubarraySum {
    // O(n)
    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, from = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                win = Math.min(win, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }

    public static void main(String[] args){
        int[] nums = {1,10,11,11,1,2,3};
        int res = minSubArrayLen(11,nums);
        System.out.print(res);
    }

}
