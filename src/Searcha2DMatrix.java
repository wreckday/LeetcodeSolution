/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
    [ 1,   3,  5,  7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 *
 * Created by Mellon on 8/27/16.
 */
public class Searcha2DMatrix {
    // big O is logN+logM
    public static boolean searchMatrix(int[][] matrix, int target) {
        // search which row first
        int l = 0;
        int h = matrix.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(matrix[m][matrix[0].length-1]==target){
                return true;
            }else if(matrix[m][matrix[0].length-1]>target){
                h = m-1;
            }else if(matrix[m][matrix[0].length-1]<target){
                l = m+1;
            }
        }

        // point;
        if(l>matrix.length-1)
            return false;

        // then search col
        // l is we want
        int row = l;
        l=0;
        h=matrix[0].length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(matrix[row][m]==target){
                return true;
            }else if(matrix[row][m]>target){
                h = m-1;
            }else if(matrix[row][m]<target){
                l = m+1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 34));
    }
}
