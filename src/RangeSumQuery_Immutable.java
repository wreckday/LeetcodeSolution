/**
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 *
 * Created by Mellon on 2/5/17.
 */
public class RangeSumQuery_Immutable {
    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int res1 = numArray.sumRange(0, 5);
        System.out.println(res1);
    }
}

class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length];
        if(nums!=null&&nums.length>0) dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return dp[j];
        return dp[j]-dp[i-1];
    }
}
