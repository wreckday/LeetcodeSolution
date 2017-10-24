import java.util.*;
/**
 Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

 Especially, this path can be either increasing or decreasing.

 For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
 On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

 * Created by Mellon on 4/10/17.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k)
                max = i + 1;
            else if (map.containsKey(sum - k))
                max = Math.max(max, i - map.get(sum - k));

            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }

}
