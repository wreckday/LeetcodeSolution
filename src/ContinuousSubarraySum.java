import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 2/25/17.
 */
public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        for(int i=0;i<nums.length-1;i++){
            int sum=nums[i];
            for(int j = i+1;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum==0&&k==0 || sum%k==0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] input = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(input, 5));
    }
}
