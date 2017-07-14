import java.util.Arrays;

/**
 * Created by Mellon on 5/13/17.
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = 0;
        int end = nums.length-1;


        while(start<nums.length&&nums[start]==copy[start]){
            start++;
        }
        while(end>=0&&nums[end]==copy[end]){
            end--;
        }
        int res = end-start+1;
        return res>0?res:0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = {3, 4, 8, 9, 10, 15};
        int[] nums3 = {};
        int res = findUnsortedSubarray(nums3);
        System.out.println(res);
    }
}
