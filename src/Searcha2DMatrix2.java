/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 *
 * Created by Mellon on 10/28/16.
 */
public class Searcha2DMatrix2 {
    /*   O(m+n)
    Here's a simple approach:

    Start at the bottom-left corner.
    If the target is less than that value, it must be above us, so move up one.
    Otherwise we know that the target can't be in that column, so move right one.
    Goto 2.
    For an NxM array, this runs in O(N+M). I think it would be difficult to do better. :)
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int col = 0;
        int row = matrix.length - 1;
        while (col <= matrix[0].length - 1 && row >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col])
                row--;
            else if (target > matrix[row][col])
                col++;
        }
        return false;
    }
}
