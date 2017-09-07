/**
 Given an array consisting of n integers,
 find the contiguous subarray of given length k that has the maximum average value.

 And you need to output the maximum average value.

 Example 1:

 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].
 *
 * Created by Mellon on 7/21/17.
 */
public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        // corner case
        double sum = 0;
        if(nums.length<k){
            double len = nums.length;
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
            }
            return sum/len;
        }

        double[] sums = new double[nums.length];

        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        sums[k-1] = sum;
        double max = sum;
        for(int i=k;i<nums.length;i++){
            sums[i] = sums[i-1]-nums[i-k] + nums[i];
            max = Math.max(max, sums[i]);
        }
        return max/k;
    }

    public static void main(String[] args){
        int[] input = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(input, k));

        int[] input2 = {5};
        int k2 = 1;
        System.out.println(findMaxAverage(input2, k2));
    }
}
