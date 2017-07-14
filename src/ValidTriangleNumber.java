import java.util.Arrays;

/**
 * Created by Mellon on 6/10/17.
 */
public class ValidTriangleNumber {
/*
    Time complexity : O(n^3)
Three nested loops are there to check every triplet.
Space complexity : O(1)O(1). Constant space is used.
* */
    public static int triangleNumberBruteForce(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]>nums[k]){
                        count = count+1;
                    }else break;
                }
            }
        }
        return count;
    }

    /*
    Algorithm

As discussed in the last approach, once we sort the given nums array,
we need to find the right limit of the index k for a pair of indices (i, j)
chosen to find the count of elements satisfying nums[i] + nums[j] > nums[k]
for the triplet (nums[i], nums[j], nums[k]) to form a valid triangle.

We can find this right limit by simply traversing the index k's values starting
from the index k=j+1 for a pair (i, j) chosen and stopping
at the first value of k not satisfying the above inequality.
Again, the count of elements nums[k] satisfying nums[i] + nums[j] > nums
for the pair of indices (i, j) chosen is given by k - j - 1 as discussed in the last approach.

Further, as discussed in the last approach, when we choose a higher value of index j for a particular i chosen,
we need not start from the index j + 1.
Instead, we can start off directly from the value of k where we left for the last index j.
This helps to save redundant computations.
    * */
    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }

/*
    Complexity Analysis

Time complexity : O(n^2) Loop of k and j will be executed O(n^2) times in total,
because, we do not reinitialize the value of k for a new value of j chosen(for the same i).
Thus the complexity will be O(n^2+n^2)=O(n^2).

Space complexity : O(1). Constant space is used.
    * */

    public static void main(String[] args){
        int[] sides = {2, 2, 3, 4};
        int res = triangleNumber(sides);
        System.out.print(res);
    }
}
