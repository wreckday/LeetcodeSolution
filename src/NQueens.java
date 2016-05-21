import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 4/24/16.
 * [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class NQueens {
    static int GRID_SIZE;
    public static List<List<String>> solveNQueens(int n) {
        GRID_SIZE= n;
        List<List<String>> res = new ArrayList<List<String>>();
        helper(0, new int[GRID_SIZE], res);
        return res;
    }

    private static void helper(int row, int[] queenForRow, List<List<String>> res){
        // base case
        if(row==GRID_SIZE){
            List<String> item = new ArrayList<String>();
            for(int i=0;i<GRID_SIZE;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<GRID_SIZE;j++){
                    if(queenForRow[i]==j){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                item.add(sb.toString());
            }
            res.add(item);
            return;
        }

        for(int i=0;i<GRID_SIZE;i++){
            queenForRow[row]=i;
            if(isValid(row, queenForRow)){
                helper(row+1, queenForRow, res);
            }
        }

    }

    private static boolean isValid(int row, int[] queenForRow){
        for(int i=0;i<row;i++){
            if(queenForRow[row]==queenForRow[i] || Math.abs(queenForRow[row]-queenForRow[i])==row-i)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        solveNQueens(1);
    }
}
