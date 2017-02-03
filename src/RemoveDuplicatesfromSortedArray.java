import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.


 * Created by Mellon on 8/27/16.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;

        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }

    public static int lastRemaining(int n) {
        List<Integer> integerList = new ArrayList<>();
        boolean isFromLeftToRight = true;
        for (int i = 1; i <= n; i++) {
            integerList.add(i);
        }

        while (integerList.size() > 1) {
            int start;
            if(isFromLeftToRight){
                start = 0;
            }else {
                if(integerList.size()%2==1){
                    start = 0;
                }else{
                    start = 1;
                }
            }

            while (start < integerList.size()) {
                integerList.remove(start++);
            }
            isFromLeftToRight = !isFromLeftToRight;

        }
        return integerList.get(0);
    }

    public static void main(String[] args){

        System.out.print(lastRemaining(11));
    }
}
