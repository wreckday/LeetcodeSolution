/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        //O(n)
        if(A==null||A.length==0)
            return 0;
        // 1. set two variables (local, global)

        int local = A[0];
        int global = local;
        for(int i=1;i<A.length;i++){
            // 就是局部最优是一定要包含当前元素
            local = Math.max(local+A[i],A[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}
