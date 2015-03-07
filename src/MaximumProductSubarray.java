/**
 * Created by Mellon on 2/22/15.
 *

 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        // 还是用一维动态规划中的“局部最优和全局最优法”。这里的区别是维护一个局部最优不足以求得后面的全局最优，
        //这是由于乘法的性质不像加法那样，累加结果只要是正的一定是递增，
        //乘法中有可能现在看起来小的一个负数，后面跟另一个负数相乘就会得到最大的乘积
        //只需要在维护一个局部最大的同时，在维护一个局部最小
        //这样如果下一个元素遇到负数时，就有可能与这个最小相乘得到当前最大的乘积和
        //O(n)
        if(A==null||A.length==0)
            return 0;

        int local_max = A[0];
        int local_min = A[0];
        int global = A[0];

        for(int i=1;i<A.length;i++){
            int local_max_copy = local_max;

            // 就是局部最优是一定要包含当前元素
            local_max = Math.max(Math.max(local_max*A[i], A[i]), local_min*A[i]);
            local_min = Math.min(Math.min(local_max_copy*A[i], A[i]), local_min*A[i]);
            global = Math.max(local_max, global);
        }
        return global;
    }
}
