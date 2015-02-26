/**
 * Created by Mellon on 2/22/15.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        // Dynamic programing
        if(A==null || A.length == 0)
            return false;

        // Global variable;
        int reach = 0;
        // point:  (reach: 最遠可以走到的位置; so i<=reach)
        for(int i=0;i<=reach&&i<A.length;i++)
        {
            reach = Math.max(A[i]+i, reach);
            if(reach >= A.length-1)
                break;
        }

        if(reach<A.length-1)
        {
            return false;
        }
        return true;
    }
}
