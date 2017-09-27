/**
 * Created by Mellon on 9/26/17.
 */
public class FirstMissingPositive {
    /*
    題目要求找出第一個沒有出現的正數, 那我們就可以用原來的array 的index 來記錄出現過的正數, iterate 每一個元素,
    當出現正數x時, 要swap 到 array index (x-1), 如果是正數, 且小於array 的長度, 繼續swap num[x-1] 直到數字值跟index差1為止,
    每一個正數移動最多2 次, 負數最多一次, 所以還是O(n)
    */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)    return i+1;
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {3, 4, -1, 1};
        System.out.print(firstMissingPositive(input));
    }
}
