/**
 * Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3

 * Created by Mellon on 4/25/15.
 */
public class NumberofIslands {
    public int numIslands(char[][] grid)
    {

        if(grid==null || grid.length==0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int cc = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    dfs(i, j, grid, visited);
                    cc++;
                }
            }
        }
        return cc;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && !visited[row][col] && grid[row][col]=='1'){
            visited[row][col] = true;
            dfs(row+1, col, grid, visited);
            dfs(row, col+1, grid, visited);
            dfs(row-1, col, grid, visited);
            dfs(row, col-1, grid, visited);
        }
    }
}
