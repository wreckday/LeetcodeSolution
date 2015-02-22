/**
 * Created by Mellon on 2/22/15.
 */
public class MinimumPathSum {
    // bigO(M*N)
    // DP
    public int minPathSum(int[][] grid) {
        if(grid==null || grid[0].length==0 || grid.length==0)
            return 0;

        int[] res = new int[grid[0].length];

        res[0] =  grid[0][0];

        for(int i=1;i<grid[0].length;i++){
            res[i] = res[i-1]+grid[0][i];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(j==0){
                    res[j] = res[j]+grid[i][j];
                }else{
                    res[j] = Math.min(res[j-1],res[j])+grid[i][j];
                }
            }
        }
        return res[grid[0].length-1];
    }
}
