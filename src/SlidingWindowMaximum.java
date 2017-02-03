import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 *
 * Created by Mellon on 7/23/16.
 */
public class SlidingWindowMaximum {
    // time complexity O(n)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove bigger numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] > nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }

    public static int[][] maxAndMinSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0][0];
        }
        int n = nums.length;
        int[][] r = new int[2][n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q_min = new ArrayDeque<>();
        Deque<Integer> q_max = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!q_min.isEmpty() && q_min.peek() < i - k + 1) {
                q_min.poll();
            }
            if (!q_max.isEmpty() && q_max.peek() < i - k + 1) {
                q_max.poll();
            }
            // remove bigger numbers in k range as they are useless
            while (!q_min.isEmpty() && nums[q_min.peekLast()] > nums[i]) {
                q_min.pollLast();
            }

            // remove smaller numbers in k range as they are useless
            while (!q_max.isEmpty() && nums[q_max.peekLast()] < nums[i]) {
                q_max.pollLast();
            }

            // q contains index... r contains content
            q_min.offer(i);
            q_max.offer(i);
            if (i >= k - 1) {
                r[0][ri] = nums[q_min.peek()];
                r[1][ri] = nums[q_max.peek()];
                ri++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        Common.printIntegerArray(maxSlidingWindow(nums, k));
        Common.printIntegerArray(minSlidingWindow(nums, k));

        int[][] res = maxAndMinSlidingWindow(nums, k);
        Common.print2DIntegerArray(res);
    }
}