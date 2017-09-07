import java.util.Arrays;

/**
 * Created by Mellon on 9/4/17.
 */
public class NondecreasingArray {
    /*
    This problem is like a greedy problem.
    When you find nums[i-1] > nums[i] for some i,
    you will prefer to change nums[i-1]'s value,
    since a larger nums[i] will give you more risks that you get inversion errors after position i.
    But, if you also find nums[i-2] > nums[i],
    then you have to change nums[i]'s value instead,
    or else you need to change both of nums[i-2]'s and nums[i-1]'s values.
    * */
    public boolean checkPossibilityGreedy(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1;
    }


    public static boolean checkPossibility(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int modifiedItem = 0;
        for(int i=copy.length-2;i>=0;i--){
            if(copy[i]>copy[i+1]){
                copy[i] = copy[i+1];
                modifiedItem++;
            }
        }

        int modifiedItem2 = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                nums[i+1] = nums[i];
                modifiedItem2++;
            }
        }
        return modifiedItem<2 || modifiedItem2<2;
    }



    public static void main(String[] args){
        int[] nums = {2, 3, 3, 2, 4};
        int[] nums2 = {4, 3, 4, 4, 5 };
        int[] nums3 = {4, 3};
        int[] nums4 = {4};
        System.out.println(checkPossibility(nums4));
    }
}
