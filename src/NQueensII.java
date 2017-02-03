/**
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * Created by Mellon on 8/23/16.
 */
public class NQueensII {
    static int GRID_SIZE;
    int count = 0;
    public int totalNQueens(int n) {
        GRID_SIZE= n;

        helper(0, new int[GRID_SIZE]);
        return count;
    }

    private void helper(int row, int[] queenForRow){
        // base case
        if(row==GRID_SIZE){
            count++;
            return;
        }

        for(int i=0;i<GRID_SIZE;i++){
            queenForRow[row]=i;
            if(isValid(row, queenForRow)){
                helper(row+1, queenForRow);
            }
        }

    }

    private boolean isValid(int row, int[] queenForRow){
        for(int i=0;i<row;i++){
            if(queenForRow[row]==queenForRow[i] || Math.abs(queenForRow[row]-queenForRow[i])==row-i)
                return false;
        }
        return true;
    }
}
