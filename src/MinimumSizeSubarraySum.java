import java.util.Arrays;

/**
 * Created by Mellon on 8/2/15.
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int l=0;
        int r=-1;

        int min = Integer.MAX_VALUE;
        int sum=0;

        while(r<nums.length){

            while(sum<s && r< nums.length){
                r++;
                if(r<nums.length)
                    sum = sum + nums[r];


            }

            if(sum >= s){
                min = Math.min(r-l+1, min);
                sum = sum-nums[l];
                l++;
            }
        }

        if(min<Integer.MAX_VALUE)
            return min;

        return 0;
    }

    public static void main(String[] args){
        int[] nums = {1,10,11,11,1,2,3};
        int res = minSubArrayLen(11,nums);
        System.out.print(res);
    }

}
