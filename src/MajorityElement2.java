import java.util.ArrayList;
import java.util.List;

/**
 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 The algorithm should run in linear time and in O(1) space.

 Hint:

 How many majority elements could it possibly have?
 Do you have a better hint? Suggest it!

 * Created by Mellon on 10/14/16.
 */
public class MajorityElement2 {
/*
    For those who aren't familiar with Boyer-Moore Majority Vote algorithm,
I found a great article (http://goo.gl/64Nams) that helps me to understand this fantastic algorithm!!
Please check it out!

The essential concepts is you keep a counter for the majority number X.
If you find a number Y that is not X, the current counter should deduce 1.
The reason is that if there is 5 X and 4 Y, there would be one (5-4) more X than Y.
This could be explained as "4 X being paired out by 4 Y".

And since the requirement is finding the majority for more than ceiling of [n/3],
the answer would be less than or equal to two numbers.
So we can modify the algorithm to maintain two counters for two majorities.
*/
    public static List<Integer> majorityElement(int[] nums) {
        Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
        for (Integer num : nums) {
            if (num.equals(major1)) {
                cnt1++;
            } else if (num.equals(major2)) {
                cnt2++;
            } else if (cnt1 == 0) {
                major1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                major2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for (Integer num : nums) {
            if (num.equals(major1)) cnt1++;
            else if (num.equals(major2)) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        if (cnt1 > nums.length / 3) result.add(major1);
        if (cnt2 > nums.length / 3) result.add(major2);
        return result;
    }

    public static void main(String[] args){
        //int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1,3,3,2,4};
        //int[] nums3 = {2, 3, 2, 3, 5};
        //Common.printIntegerList(majorityElement(nums1));
        Common.printIntegerList(majorityElement(nums2));
        //Common.printIntegerList(majorityElement(nums3));
    }
/*
1. there are no elements that appears more than n/3 times,
then whatever the algorithmgot from 1st round wound be rejected in the second round.

2. there are only one elements that appears more than n/3 times,
 after 1st round one of the candicate must be that appears more than n/3 times(<2n/3 other elements could only
 pair out for <n/3 times), the other candicate is not necessarily be the second most frequent
 but it would be rejected in 2nd round.

3. there are two elments appears more than n/3 times, candicates would contain both of
 them. (<n/3 other elements couldn't pair out any of the majorities.)
*/
}
