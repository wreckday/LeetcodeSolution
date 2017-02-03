/**
 After robbing those houses on that street,
 the thief has found himself a new place for his thievery so that he will not get too much attention.
 This time,all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Created by Mellon on 6/23/16.
 */
public class HouseRobberII {
    /*
    Since this question is a follow-up to House Robber,
    we can assume we already have a way to solve the simpler question,
    i.e. given a 1 row of house, we know how to rob them.
    So we already have such a helper function. We modify it a bit to rob a given range of houses.
    * */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }

    private static int robHelper(int[] nums, int start, int end) {
        int curr, prev, prev2;
        curr = prev = prev2 = 0;

        for (int i = start; i <= end; i++) {
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
