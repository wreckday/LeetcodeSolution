/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 *
 * Created by Mellon on 5/20/17.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]==target) return m;

            if(nums[m]<nums[r]){
                // m to r should be in order sequence
                if(target>nums[m]&&target<=nums[r])
                    l = m+1;
                else
                    r = m-1;
            } else {
                // l to m should be in order
                if(target<nums[m] && target>=nums[l])
                    r = m-1;
                else
                    l = m+1;
            }
        }
        return -1;
    }
}
