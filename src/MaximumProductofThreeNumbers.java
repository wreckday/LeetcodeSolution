import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mellon on 6/24/17.
 */
public class MaximumProductofThreeNumbers {
    public static int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[n-1], nums[n-1] * nums[n-2] * nums[n-3]);
    }

    public static void main(String[] args){
        int[] nums = {-1, -2, 9, 8, 0};
        int[] nums2 = { -1, -3, 9, 1};
        System.out.println(maximumProduct(nums2));
    }

}
