/**
 Given an array of integers that is already sorted in ascending order,
 find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2


 *
 * Created by Mellon on 9/25/16.
 */
public class TwoSumII_Inputarrayissorted {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length-1;
        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum==target){
                res[0]=start+1;
                res[1]=end+1;
                return res;
            }else if(sum>target){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Common.printIntegerArray(twoSum(nums, target));
    }
}

