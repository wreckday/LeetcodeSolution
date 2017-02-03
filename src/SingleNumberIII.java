/**
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * Created by Mellon on 1/7/17.
 */


public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //b^c
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] results = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                results[0] ^= num;
            }
            else // the bit is set
            {
                results[1] ^= num;
            }
        }
        return results;
    }
}

/*
Time: O (n), Space: O (1)

Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find.
Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result.
Find out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set,
another with the aforementinoed bit unset.
Two different numbers we need to find must fall into the two distinct groups.
XOR numbers in each group, we can find a number in either group.

那么我们如果能想办法把原数组分为两个小数组，不相同的两个数字分别在两个小数组中，
这样分别调用Single Number 单独的数字的解法就可以得到答案。那么如何实现呢，
首先我们先把原数组全部异或起来，那么我们会得到一个数字，这个数字是两个不相同的数字异或的结果
我们取出其中任意一位为‘1’的位，为了方便起见，我们用 a &= -a 来取出最右端为‘1’的位，
然后和原数组中的数字挨个相与，那么我们要求的两个不同的数字就被分到了两个小组中，
分别将两个小组中的数字都异或起来，就可以得到最终结果了
*
*/