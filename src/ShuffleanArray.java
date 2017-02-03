import java.util.Random;

/**
 Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 *
 * Created by Mellon on 8/18/16.
 */
public class ShuffleanArray {
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);

        int[] param_2 = obj.shuffle();

        int[] param_1 = obj.reset();

        Common.printIntegerArray(param_2);
        Common.printIntegerArray(param_1);
    }
}
 class Solution {

    private int[] input_array;
    private Random random = new Random();

    public Solution(int[] nums) {
        input_array = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return input_array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy_array = input_array.clone();
        for (int i=0; i<copy_array.length; i++) {
            int randomPosition = random.nextInt(copy_array.length);
            int temp = copy_array[i];
            copy_array[i] = copy_array[randomPosition];
            copy_array[randomPosition] = temp;
        }
        return  copy_array;
    }
}

