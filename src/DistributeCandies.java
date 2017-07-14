import java.util.*;

/**
 * Created by Mellon on 5/10/17.
 */
public class DistributeCandies {
    public static int distributeCandies(int[] candies) {
        int max = candies.length/2;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<candies.length;i++){
            set.add(candies[i]);
        }
        if(set.size()>=max) return max;
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 4};
        int[] nums2 = {1, 1, 1, 1, 1, 1, 3, 4};
        int[] nums3 = {1, 2, 3, 4, 1, 2, 3, 4};
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 1};
        System.out.println(distributeCandies(nums));
        System.out.println(distributeCandies(nums2));
        System.out.println(distributeCandies(nums3));
        System.out.println(distributeCandies(nums4));
    }
}
