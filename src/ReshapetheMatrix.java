/**
 * Created by Mellon on 4/29/17.
 */
public class ReshapetheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int count = r*c;

        if(nums.length*nums[0].length != count) return nums;

        int[][] reshape = new int[r][c];

        int row = 0, col = 0;
        for(int i=0;i<reshape.length;i++){
            for(int j=0;j<reshape[0].length;j++){
                reshape[i][j] = nums[row][col];
                col++;
                if(col == nums[0].length){
                    col=0;
                    row++;
                }
            }
        }
        return reshape;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},{3, 4}
        };

        int[][] res = matrixReshape(nums, 1, 4);

        Common.print2DIntegerArray(res);

    }
}
