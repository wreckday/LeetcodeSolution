/**
 * Created by Mellon on 3/8/15.

 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
    //基本思路就是维护一个长度为n的数组，进行两次扫描，一次从左往右，一次从右往左。
    // 第一次扫描的时候维护從左边算起到這個bar最大的高度是多少，存入数组对应元素中，
    // 第二次扫描的时候维护右边最大的高度，并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组对应元素中。
    // 这样两遍扫描之后就可以得到每一个bar能承受的最大水量，从而累加得出结果。
    // 这个方法只需要两次扫描，所以时间复杂度是O(2*n)=O(n)。空间上需要一个长度为n的数组，复杂度是O(n)。代码如下：
    // for example, A = {2,6,3,8,2,7,2,5,0}
    public int trap(int[] A) {
        if(A==null || A.length==0)
            return 0;
        int max = 0;
        int res = 0;
        int[] container = new int[A.length];
        // container stores the highest point from left side
        for(int i=0;i<A.length;i++)
        {
            container[i]=max;
            max = Math.max(max,A[i]);
        }

        // r[i] is the highest point from right to i
        int maxFromRight = A[A.length-1];

        for(int i=A.length-2;i>=0;i--){

            maxFromRight=Math.max(maxFromRight,A[i]);
            // compare left[] and right[] and choose the lower one to calculate the container of water.
            res += (Math.min(maxFromRight,container[i])-A[i]>0)?Math.min(maxFromRight,container[i])-A[i]:0;
        }


    /*

    // now container[] is {0,2,6,6,8,8,8,8,8}
    max = 0; // max is the hightest point from the right side
    for(int i=A.length-1;i>=0;i--)
    {
        //we are here at the point, and we want to compare the highest from the left (container[i])
        // with the highest from the right (max), and choose the low one. then store it to container

        container[i] = Math.min(max,container[i]);

        //max: get the next element right highest point
        max = Math.max(max,A[i]);

        // container[] - A[i]: the volume of the tapping water.
        res += container[i]-A[i]>0?container[i]-A[i]:0;
    }    */
        return res;
    }
}
