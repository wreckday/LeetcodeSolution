/**
 * Created by Mellon on 2/22/15.
 */
public class JumpGame2 {
    /*
   全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
   当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，我们就可以更新步数，
   将step+1。时间复杂度仍然是O(n)，空间复杂度也是O(1)。
   */
    public static int jump(int[] A) {
        if(A==null || A.length==0)
            return 0;

        // global
        int reach=0;
        // two more variables compared to jump game
        int last_reach=0;
        int step=0;

        for(int i=0;i<=reach&&i<A.length;i++){
            // point
            if(i>last_reach){
                step++;
                last_reach = reach;
            }

            reach = Math.max(A[i]+i, reach);
        }

        if(reach<A.length-1)
            return 0;

        return step;
    }


    public static void main(String[] args){
        int[] input = {2, 3, 1, 1, 4};
        System.out.println(jump(input));
    }
}
