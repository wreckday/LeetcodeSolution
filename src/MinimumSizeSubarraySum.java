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
        int[] nums2 = {2, 3, 1, 2, 4, 3};
//        int res = minSubArrayLen(11,nums);
//        int res2 = minSubArrayBinarySearch(11,nums);
//        int res3 = minSubArrayLen(7,nums2);
//        int res4 = minSubArrayBinarySearch(7,nums2);



        int[] nums3 = {1, 2, 3, 4, 5};
        int res5 = minSubArrayBinarySearch(11,nums3);
        //int res6 = minSubArrayLen(11, nums3);
//        System.out.println(res);
//        System.out.println(res2);
        System.out.println(res5);
        //System.out.println(res6);
    }

    public static int minSubArrayBinarySearch(int s, int[] nums){
        if(nums==null || nums.length==0) return 0;
        int min = Integer.MAX_VALUE;
        // build cumulative sum[]
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sums[i] = sums[i-1] + nums[i];
        }
        // for every element do binary search
        for(int i=0;i<nums.length;i++){
            // -insertion point-1
            int end = Arrays.binarySearch(sums, i, nums.length, (sums[i]-nums[i])+s);
            if(end<0) {
                end = -end-1;
            }
            if(end == sums.length) break;
            // end is the index(to) >= target
            min = Math.min(min, end-i+1);
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

}
