import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Hint:
 Could you do it in-place with O(1) extra space?
 *
 * Created by Mellon on 6/23/16.
 */
public class RotateArray {
//    1. Make an extra copy and then rotate.
//
//    Time complexity: O(n). Space complexity: O(n).
    public static void rotate1(int[] nums, int k){
        int[] copy = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i] = nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[((nums.length-k)+i)%nums.length]=copy[i];
        }
    }

//  2. in place
//     O(n)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

//  3.
//Every swap will put one number into its correct position, so the running time is O(n)
//
//    For example,
//
//    at first, nums[] is [1,2,3,4,5,6,7], n is 7, k is 3
//
//    after first outer loop, nums[] is [4,1,2,3], n is 4, k is 3
//
//    after second outer loop, nums[] is [4], n is 1, k is 0
//
//    loop ends.

    public static void rotate3(int nums[], int k) {
        // Swap the last k elements with the first k elements.
        // The last k elements will be in the correct positions
        // but we need to rotate the remaining (n - k) elements
        // to the right by k steps.
//        n=6;
//        123456
//        k=2
//
//        result:
//        561234
//
//        563412
//        | |  |
//          k  n

        int n = nums.length;
        k=k%n;
        for (int start=0; start<nums.length && k!=0 ; k = k%n){
            for (int i = 0; i < k; i++) {
                swap(nums, start+i, nums.length-k+i);
            }
            n=n-k;
            start=start+k;
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b]= nums[a];
        nums[a]=temp;
    }

    public static void main(String[] args){
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int k = 3;
        //int[] nums = buildArray(2);
        int[] nums = {4, 1, 2, 3};
        rotate3(nums, 3);
        Common.printIntegerArray(nums);
    }

    private static int[] buildArray(int len){
        int[] a = new int[len];
        for(int i=0;i<len;i++){
            a[i] = i+1;
        }
        return a;
    }
}
