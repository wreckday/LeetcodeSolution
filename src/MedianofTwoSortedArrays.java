/**
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 *
 * Created by Mellon on 6/27/16.
 */
public class MedianofTwoSortedArrays {

    // using divide and conquer idea, each time find the mid of both arrays

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /* A[0, 1, 2, ..., n-1, n] */
        /* A[0, 1, 2, ..., m-1, m] */

        int m = nums1.length;
        int n = nums2.length;

        int k = (m + n + 1) / 2;
        double v = (double)FindKth(nums1, 0, m - 1, nums2, 0, n - 1, k);

        if ((m+n) % 2 == 0) {
            int k2 = k+1;
            double v2 = (double)FindKth(nums1, 0, m - 1, nums2, 0, n - 1, k2);
            v = (v + v2) / 2;
        }

        return v;
    }

    // find the kth element int the two sorted arrays
    // let us say: A[aMid] <= B[bMid], x: mid len of a, y: mid len of b, then wen can know
    //
    // (1) there will be at least (x + 1 + y) elements before bMid
    // (2) there will be at least (m - x - 1 + n - y) = m + n - (x + y +1) elements after aMid
    // therefore
    // if k <= x + y + 1, find the kth element in a and b, but unconsidering bMid and its suffix
    // if k > x + y + 1, find the k - (x + 1) th element in a and b, but unconsidering aMid and its prefix
    private static int FindKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
        if (aL > aR) return B[bL + k - 1];
        if (bL > bR) return A[aL + k - 1];

        int aMid = (aL + aR) / 2;
        int bMid = (bL + bR) / 2;

        if (A[aMid] <= B[bMid]) {
            if (k <= (aMid - aL) + (bMid - bL) + 1)
                return FindKth(A, aL, aR, B, bL, bMid - 1, k);
            else
                return FindKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
        }
        else { // A[aMid] > B[bMid]
            if (k <= (aMid - aL) + (bMid - bL) + 1)
                return FindKth(A, aL, aMid - 1, B, bL, bR, k);
            else
                return FindKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
        }
    }

    public static void main(String[] args){
        int[] num1 = {1, 2, 2, 3, 4, 4, 5};
        int[] num2 = {1, 2, 3, 4, 5};
        System.out.print(findMedianSortedArrays(num1, num2));
    }
}
