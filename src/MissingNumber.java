import java.util.Arrays;

/**

 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?

 *
 * Created by Mellon on 9/24/15.
 */
public class MissingNumber {
   // The array element are not sorted.

    // The basic idea is to use XOR operation.
    // We all know that a^b^b =a,
    // which means two xor operations with the same number will eliminate the number and reveal the original number.
    // In this solution, I apply XOR operation to both the index and value of the array.
    // In a complete array with no missing numbers,
    // the index and value should be perfectly corresponding( nums[index] = index),
    // so in a missing array, what left finally is the missing number.

    public static int missingNumber(int[] nums){
        int xor=0; int i=0;
        for(i=0;i<nums.length;i++){
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    public static int missingNumberBase1(int[] nums){
        int xor = 0; int index = 1;
        for(int e : nums){
            xor = xor ^ e ^ index;
            index ++;
        }
        return xor ^ index;
    }

    public static int missingNumber_Sum(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 3, 4};
        int ans = missingNumber(nums);

        int[] nums2 = {2, 3, 4, 5};
        int ans2 = missingNumberBase1(nums2);
        System.out.print(ans2);
    }


}
