/**
 * Created by Mellon on 3/8/15.

 Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {

        if(board == null || board.length != 9 || board[0].length !=9)
            return;

        helper(board,0,0);
    }

    private boolean helper(char[][] board, int i, int j)
    {  // go down to the next row after checking the right most element
        if(j>=9)
            return helper(board,i+1,0);

        // base case
        if(i==9)
        {
            return true;
        }

        if(board[i][j]=='.')
        {
            for(int k=1;k<=9;k++)
            {
                board[i][j] = (char)(k+'0');
                if(isValid(board,i,j))
                {
                    if(helper(board,i,j+1))
                        return true;
                }
                board[i][j] = '.';
            }
        }
        else
        {
            return helper(board,i,j+1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j)
    {   // check no the same element as i already existed in th row
        for(int k=0;k<9;k++)
        {
            if(k!=j && board[i][k]==board[i][j])
                return false;
        }
        // check no the same element as j already existed in the col
        for(int k=0;k<9;k++)
        {
            if(k!=i && board[k][j]==board[i][j])
                return false;
        }

        // ex: board[1][5]  ---->  need to check i=0,1,2 ; j=3,4,5. That's why i/3 and j/3
        for(int row = i/3*3; row<i/3*3+3; row++)
        {
            for(int col=j/3*3; col<j/3*3+3; col++)
            {
                if((row!=i || col!=j) && board[row][col]==board[i][j])
                    return false;
            }
        }
        return true;
    }
}
