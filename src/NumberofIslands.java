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
    int row,col;
    boolean[][] visited;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};


    public int numIslands(char[][] grid)
    {
        if(grid==null || grid.length==0) return 0;

        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];

        // connected component
        int cc=0;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    dfs(i,j, grid);
                    cc++;
                }
            }
        }
        return cc;
    }

    private void dfs(int y, int x, char[][] grid)
    {
        for(int d=0;d<4;++d)
        {
            int ny = y + dir[d][0];
            int nx = x + dir[d][1];

            if(ny>=0 && ny<row && nx>=0 && nx<col && grid[ny][nx]=='1')
            {
                if(!visited[ny][nx])
                {
                    visited[ny][nx]=true;
                    dfs(ny, nx, grid);
                }
            }
        }
    }
}
