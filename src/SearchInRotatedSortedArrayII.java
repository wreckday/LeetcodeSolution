/**
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 *
 * Created by Mellon on 5/20/17.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A==null || A.length==0)
            return false;
        int l=0;
        int r=A.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(A[m]==target)
                return true;

            if(A[m]<A[r]) {
                // right part is in order
                if(target<=A[r]&&target>A[m])
                    l=m+1;
                else
                    r=m-1;

            }else if(A[m]>A[r]) {
                // left part is in order
                if(target<A[m]&&target>=A[l])
                    r=m-1;
                else
                    l=m+1;
            }else if(A[m]==A[r]){// point: if A[m]==A[r]
                r--;
            }
//以上方法和Search in Rotated Sorted Array是一样的，只是添加了中间和边缘相等时，边缘移动一步，但正是这一步导致算法的
//复杂度由O(logn)变成了O(n)。个人觉得在面试中算法复杂度还是很重要的考察点，因为涉及到对算法的理解，大家还是要尽量多考虑哈。
        }
        return false;
    }
}
