/**
 * Created by Mellon on 9/9/17.
 */
public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int max = 1;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }
        return Math.max(count, max);
    }

    public static void main(String[] args){
        int[] input = {2, 2, 4, 1, 2, 4};
        System.out.println(findLengthOfLCIS(input));
    }
}
