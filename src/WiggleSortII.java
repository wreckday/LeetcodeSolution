import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * <p>
 * <p>
 * Created by Mellon on 4/1/17.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        // leetcode : 215
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;
        // leetcode 75 red-white-blue sort color
        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    //https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    /*
    O(N lg K) running time + O(K) memory
    Other possibility is to use a min oriented priority queue that will store the K-th largest values.
    The algorithm iterates over the whole input and maintains the size of priority queue.
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }

        int res = -1;
        for(int i=0;i<k;i++){
            res = pq.poll();
        }
        return res;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /*
    First I find a median using nth_element.
    That only guarantees O(n) average time complexity and I don't know about space complexity.
    I might write this myself using O(n) time and O(1) space, but that's not what I want to show here.

    This post is about what comes after that.
    We can use three-way partitioning to arrange the numbers so that those larger than the median come first,
    then those equal to the median come next, and then those smaller than the median come last.

    Ordinarily, you'd then use one more phase to bring the numbers to their final positions to reach the overall wiggle-property.
    But I don't know a nice O(1) space way for this. Instead,
    I embed this right into the partitioning algorithm.
    That algorithm simply works with indexes 0 to n-1 as usual,
    but sneaky as I am, I rewire those indexes where I want the numbers to actually end up.
    The partitioning-algorithm doesn't even know that I'm doing that,
    it just works like normal (it just uses A(x) instead of nums[x]).

    Let's say nums is [10,11,...,19]. Then after nth_element and ordinary partitioning, we might have this (15 is my median):

    index:     0  1  2  3   4   5  6  7  8  9
    number:   18 17 19 16  15  11 14 10 13 12
    I rewire it so that the first spot has index 5, the second spot has index 0, etc, so that I might get this instead:

    index:     5  0  6  1  7  2  8  3  9  4
    number:   11 18 14 17 10 19 13 16 12 15
    And 11 18 14 17 10 19 13 16 12 15 is perfectly wiggly.
    And the whole partitioning-to-wiggly-arrangement
    (everything after finding the median) only takes O(n) time and O(1) space.
    * */
}
