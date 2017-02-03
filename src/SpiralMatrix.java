import java.util.ArrayList;
import java.util.List;

/**
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 *
 * Created by Mellon on 8/24/16.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int rowMin = 0, rowMax = matrix.length-1, colMin = 0, colMax = matrix[0].length-1;

        while(rowMin <= rowMax && colMin <= colMax) {
            for(int i=colMin; i<=colMax; i++) list.add(matrix[rowMin][i]);
            rowMin++;

            for(int i=rowMin; i<=rowMax; i++) list.add(matrix[i][colMax]);
            colMax--;

            if(rowMin > rowMax || colMin > colMax) break;

            for(int i=colMax; i>=colMin; i--) list.add(matrix[rowMax][i]);
            rowMax--;

            for(int i=rowMax; i>=rowMin; i--) list.add(matrix[i][colMin]);
            colMin++;
        }
        return list;
    }
}
