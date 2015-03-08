import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 2/8/15.
 *
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
    // bigO (n square)
    public static boolean isValidSudoku(char[][] board) {

        // build row and col cases
        for(int i=0;i<9;i++){
            char[] cur = new char[9];
            char[] cur2 = new char[9];
            for(int j=0;j<9;j++){

                cur[j] = board[i][j];
                cur2[j] = board[j][i];
            }

            if(!isValid(cur)||!isValid(cur2))
                return false;
        }

        // point: please remember it  use '/' to get row(go down), use '%' to get col(go right)
        // build block cases
        for(int block=0;block<9;block++)
        {
            int index=0;
            char[] cur = new char[9];

            for(int i=block/3*3;i<block/3*3+3;i++)
            {
                for(int j=block%3*3;j<block%3*3+3;j++)
                {
                    cur[index] = board[i][j];
                    index++;
                }
            }

            if(!isValid(cur))
                return false;
        }
        return true;
    }

    private static boolean isValid(char[] row){
        boolean[] map = new boolean[9];
        for(int i=0;i<row.length;i++){
            if(row[i]=='.')
                continue;
            int index = row[i]-'0';
            if(map[index-1]){
                return false;
            }else{
                map[index-1] = true;
            }
        }
        return true;
    }


    private static char[][] buildGrid(String s){
        char[][] grid = new char[9][9];
        for(int i=0;i<s.length();i++){
            int row = i/9;
            int col = i%9;

            grid[row][col] = s.charAt(i);
        }
        return grid;
    }

    public static void main(String[] args){
        String input = ".876543212........3........4........5........6........7........8........9........";
        char[][] board = buildGrid(input);
        System.out.println(isValidSudoku(board));
    }
}
