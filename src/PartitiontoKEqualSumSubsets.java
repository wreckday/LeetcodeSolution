import java.util.Arrays;

/**
 * Created by Mellon on 10/14/17.
 */
public class PartitiontoKEqualSumSubsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // [2,2,10,5,2,7,2,2,13]
        //  x x    x x   x x
        //  0,1,2 ,3,4,5,6,7,8
        // target 15
        // 10 5 | 2 13 | 2 2 2 7 2
        int sum = 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }

        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (max > target) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];

        return canPartitionKSubsets(nums, target, 0, k, target, visited);
    }

    private static boolean canPartitionKSubsets(int[] nums, int target, int start, int k, int sum, boolean[] visited) {
        if (k == 1) return true;
        if (sum == 0) return canPartitionKSubsets(nums, target, 0, k - 1, target, visited);

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartitionKSubsets(nums, target, i + 1, k, sum - nums[i], visited)) return true;
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int[] nums2 = {1, 2, 1, 2, 3, 1, 1, 2, 1, 1};
        System.out.println(canPartitionKSubsets(nums2, 3));
    }
}
