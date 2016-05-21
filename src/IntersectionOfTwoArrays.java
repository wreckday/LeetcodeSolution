import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 *
 * Created by Mellon on 5/19/16.
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i]))
                set2.add(nums2[i]);
        }

        int[] res = new int[set2.size()];
        int i=0;
        for(Integer d :set2){
            res[i] = d;
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection(nums1, nums2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
