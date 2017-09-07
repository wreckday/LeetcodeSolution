/**
 * Created by Mellon on 8/19/17.
 */
public class ImageSmoother {
    public static int[][] imageSmoother(int[][] M) {
        if(M==null || M.length==0 || M[0]==null || M[0].length == 0) return M;
        int[][] dir = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {1, -1}, {-1, -1}, {0, -1}};
        int[][] res = new int[M.length][M[0].length];

        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                helper(res, M, i, j, M.length, M[0].length, dir);
            }
        }
        return res;
    }

    private static void helper(int[][] res, int[][] M, int i, int j, int row, int col, int[][] dir){
        int sum = M[i][j];
        int count = 1;
        for(int[] di :dir){

            int x = i + di[0];
            int y = j + di[1];

            if(x>=0&&y>=0&&x<row&&y<col){
                sum += M[x][y];
                count++;
            }
        }

        res[i][j] = sum/count;
    }

    public static void main(String[] args){
        int[][] inputs = {{2, 2, 1},
                          {2, 2, 1},
                          {1, 1, 1}};
        int[][] res = imageSmoother(inputs);
        Common.print2DIntegerArray(res);

    }


}
