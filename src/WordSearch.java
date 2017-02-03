/**
 * Created by Mellon on 3/7/15.
 *
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =

 [
    ["ABCE"],
    ["SFCS"],
    ["ADEE"]
 ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
 */
public class WordSearch {
    // O(m*n)
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int level, int row, int col, boolean[][] visited){
        //base case
        if(level == word.length()){
            return true;
        }

        if(row<0||row>board.length-1||col<0||col>board[0].length-1||board[row][col]!=word.charAt(level)||visited[row][col]){
            return false;
        }

        visited[row][col] = true;

        boolean res =  helper(board, word, level+1, row+1, col, visited)
                || helper(board, word, level+1, row, col+1, visited)
                || helper(board, word, level+1, row-1, col, visited)
                || helper(board, word, level+1, row, col-1, visited);
        visited[row][col] = false;

        return res;
    }

    public static boolean exist1(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(helper(i, j, board, visited, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper (int row, int col, char[][] board, boolean[][] visited, String word, int i){

        if(row<0||row>board.length-1||col<0||col>board[0].length-1||board[row][col]!=word.charAt(i)||visited[row][col]){
            return false;
        }


        // base case
        if (i == word.length()-1){
            return true;
        }

        if(row>=0&&row<board.length&&col>=0&&col<board[0].length&&!visited[row][col]){
            visited[row][col] = true;
            helper(row-1, col, board, visited, word, i+1);
            helper(row+1, col, board, visited, word, i+1);
            helper(row, col-1, board, visited, word, i+1);
            helper(row, col+1, board, visited, word, i+1);
        }


        visited[row][col] = false;
        return false;
    }


    public static void main(String[] args){
        char[][] bb = {{'a'}};
        System.out.println(exist1(bb, "ab"));
    }
}
