/**
 * Created by Mellon on 3/15/16.
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Given matrix = [
    [3, 0, 1, 4, 2],
    [5, 6, 3, 2, 1],
    [1, 2, 0, 1, 5],
    [4, 1, 0, 1, 7],
    [1, 0, 3, 0, 5]
 ]

    sumRegion(2, 1, 4, 3) -> 8
    sumRegion(1, 1, 2, 2) -> 11
    sumRegion(1, 2, 2, 4) -> 12
 *
 *
 *    You may assume that the matrix does not change.
 There are many calls to sumRegion function.
 You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 */
public class RangeSumQuery2D {
    int[][] matrix2;
    public RangeSumQuery2D(int[][] matrix) {
        int height = matrix.length;
        if (height == 0) return;
        int len = matrix[0].length;
        matrix2 = new int[height][len];
        matrix2[0][0] = matrix[0][0];
        // 1. build table
        for(int i=1;i<len;i++){
            matrix2[0][i] = matrix2[0][i-1]+matrix[0][i];
        }

        for(int i=1;i<height;i++){
            matrix2[i][0] = matrix2[i-1][0]+matrix[i][0];
        }

        for(int j=1;j<height;j++){
            for(int i=1;i<len;i++){
                matrix2[j][i] =  matrix2[j][i-1] + matrix2[j-1][i] - matrix2[j-1][i-1] + matrix[j][i];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return matrix2[row2][col2];
        } else if (row1 == 0 && col1 > 0) {
            return matrix2[row2][col2] - matrix2[row2][col1 - 1];
        } else if (row1 > 0 && col1 == 0) {
            return matrix2[row2][col2] - matrix2[row1 - 1][col2];
        } else {
            return matrix2[row2][col2] - matrix2[row2][col1 - 1] - matrix2[row1 - 1][col2] + matrix2[row1 - 1][col1 - 1];
        }
    }
}

