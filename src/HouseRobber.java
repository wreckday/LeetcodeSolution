/**
 * Created by Mellon on 4/5/15.
 * House Robber
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is
 * that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int curr, prev, prev2;
        curr = prev = prev2 = 0;

        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args){
        int[] nums = {5, 3, 9, 10};
        System.out.print(rob(nums));
    }
}
