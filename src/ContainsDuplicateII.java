import java.util.HashSet;

/**
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * Created by Mellon on 10/5/16.
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array
        for (int i=0; i<nums.length; i++) {
            // If already present n hash, then we found
            // a duplicate within k distance
            if (set.contains(nums[i]))
                return true;

            // Add this item to hashset
            set.add(nums[i]);

            // Remove the k+1 distant item
            if (i >= k)
                set.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1, 4, 5, 1, 3, 2};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
