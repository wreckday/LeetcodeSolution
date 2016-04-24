/**
 * Created by Mellon on 9/9/15.
 */
public class RotateImage {
    public static void rotate(int[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        int n = matrix.length;
        for(int level=0;level<n/2;level++){
            int first = level;
            int last = n-level-1;

            for(int i=first;i<last;i++){
                int offset = i-first;
                // save top
                int temp = matrix[first][i];
                // left -> up
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                // temp -> right
                matrix[i][last] = temp;
            }
        }
    }

    public static void main(String[] args){

    }
}
