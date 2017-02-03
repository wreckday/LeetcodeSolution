import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 Given an array of integers, find out whether there are two distinct indices i and j in the array
 such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 *
 * Created by Mellon on 10/7/16.
 */
public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicateSlow(int[] nums, int k, int t) {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array
        for (int i=0; i<nums.length; i++) {
            // If already present n hash, then we found
            // a duplicate within k distance
            for(int j=0;j<=t;j++){
                if (set.contains(nums[i]-j) || set.contains(nums[i]+j))
                    return true;
            }
            // Add this item to hashset
            set.add(nums[i]);

            // Remove the k+1 distant item
            if (i >= k)
                set.remove(nums[i-k]);
        }
        return false;
    }
/*
This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
The best data structure to do that is Binary Search Tree.
As a result maintaining the tree of size k will result in time complexity O(N lg K).
In order to check if there exists any value of range abs(nums[i] - nums[j])
to simple queries can be executed both of time complexity O(lg K)

Here is the whole solution using TreeMap.
* */
    public static boolean containsNearbyAlmostDuplicateTreeSet(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Long floor = values.floor((long)nums[i] + t);
            Long ceil = values.ceiling((long)nums[i] + t);
            if (floor != null && floor >= nums[i] || ceil != null && ceil <=nums[i]) {
                return true;
            }

            values.add((long)nums[i]);
            if (i >= k) {
                values.remove((long)nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] nums = {2, 1};
        int k = 1;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicateTreeSet(nums, k, t));
    }
}
