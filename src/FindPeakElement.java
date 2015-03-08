/**
 * Created by Mellon on 2/26/15.
 *
     A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the "index number" 2.


 */

public class FindPeakElement {
    //http://blog.csdn.net/u010367506/article/details/41943309
    //方法2：二分查找

    // 思路：如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。
    // 如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。
    //时间复杂度：O（lgN）
    public int findPeakElement(int[] num) {
        //0535
        int l = 0;
        int r = num.length - 1;
        while(l <= r){
            if(l == r) return l;
            int mid = (l + r) / 2;
            if(num[mid] > num[mid + 1]){
                //find on the left
                r = mid;
            } else {
                //find on the right
                l = mid + 1;
            }
        }
        return r;
    }
}
