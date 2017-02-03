/**
 *
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 * Created by Mellon on 7/7/16.
 */
public class FindMinimuminRotatedSortedArray {
    public static int findMin2(int[] num) {

        int l = 0;
        int r = num.length-1;
        int m;

        while(l<r)
        {
            m = (l+r)/2;

            // only one situation, we will need to go right (left side is sorted)
            // ex.  2, 3, 4, 5, 6, 1
            // ex.  4, 5 ,6, 1, 2, 3
            // should check num[l] > num[r] , for the test case {1, 2, 3}
            if(num[m]>=num[l]&& num[l] > num[r])
            {
                l = m+1;
            }
            else
            { // or go left   ex. 6, 1, 2, 3, 4, 5 (right side is sorted or)
                r = m;
            }
        }
        return num[l];
    }

    public static void main(String[] args){
        int[] a = {1, 2};
        System.out.print(findMin2(a));
    }
}
