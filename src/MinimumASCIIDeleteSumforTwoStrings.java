import java.util.*;

/**
 * Created by Mellon on 10/21/17.
 */
public class MinimumASCIIDeleteSumforTwoStrings {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        if (nums[0] < k) queue.add(nums[0]);
        int level = 1;
        while (!queue.isEmpty() && level < nums.length) {
            int parentSize = queue.size();
            for (int i = 0; i < parentSize; i++) {
                int parent = queue.poll();
                count++;
                if (nums[level] * parent < k)
                    queue.offer(nums[level] * parent);
            }
            if (nums[level] < k) queue.offer(nums[level]);
            level++;
        }

        return count + queue.size();
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int res = numSubarrayProductLessThanK(nums, 2);
        System.out.print(res);
    }
}
