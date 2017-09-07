import java.util.*;

/**
 * Created by Mellon on 7/22/17.
 */
public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                res[0] = nums[i];
            }
        }
        // bit manipulation XO to find missing number
        int index = 1;
        for(int i=0;i<nums.length;i++){
            res[1] = res[1] ^ nums[i] ^index;
            index++;
        }
        res[1]=res[1]^res[0];   //res[1]=2^4   //(duplicated number) res[0]=2
        return res;
    }

    public static void main(String[] args){
        int[] input = {1, 2, 2, 3, 5}; // expected{2, 4}
        int[] input2 = {1, 1}; // expected{1, 2}
        int[] input3 = {1, 2, 3, 4, 4}; // expected{4, 5}
        int[] input4 = {1, 2, 2, 4}; // expected{2, 3}
        int[] input5 = {2, 2}; // expected{2, 1}
        int[] input6 = {2, 3, 3, 4, 5, 6}; // expected{3, 1}
        int[] input7 = {1, 3, 4, 5, 5, 6, 7, 8}; // expected{5, 2}
        Common.printIntegerArray(findErrorNums(input));
        Common.printIntegerArray(findErrorNums(input2));
        Common.printIntegerArray(findErrorNums(input3));
        Common.printIntegerArray(findErrorNums(input4));
        Common.printIntegerArray(findErrorNums(input5));
        Common.printIntegerArray(findErrorNums(input6));
        Common.printIntegerArray(findErrorNums(input7));
    }
}
