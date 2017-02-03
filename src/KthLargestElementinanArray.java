import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Find the kth largest element in an unsorted array.
 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 * Created by Mellon on 6/27/16.
 */
public class KthLargestElementinanArray {
    /*
    O(N lg K) running time + O(K) memory
    Other possibility is to use a min oriented priority queue that will store the K-th largest values.
    The algorithm iterates over the whole input and maintains the size of priority queue.
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        int res = -1;
        for(int i=0;i<k;i++){
            res = pq.poll();
        }
        return res;
    }

    public static void main(String[] args){
        int[] num1 = {1, 7, 2, 55, 4, 4, 5};
        System.out.print(findKthLargest(num1, 3));
    }

}
