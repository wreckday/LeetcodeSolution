/**
 * Created by Mellon on 2/22/15.
 */
public class MaximunSubarray {
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
