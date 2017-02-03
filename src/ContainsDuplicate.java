import java.util.HashSet;
import java.util.Set;

/**
 Given an array of integers, find if the array contains any duplicates. Your function should return true
 if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Created by Mellon on 10/5/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0) return false;
        int leng = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        return (set.size()==leng)?false:true;
    }
}
