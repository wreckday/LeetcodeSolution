import java.util.*;

/**
 * Created by Mellon on 10/7/17.
 */
public class NumberofDistinctIslands {
    static int ROW = 0;
    static int COL = 0;

    public static int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        ROW = grid.length;
        COL = grid[0].length;

        boolean[][] visited = new boolean[ROW][COL];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder item = new StringBuilder();
                    int offset = i * ROW + j - 0;
                    dfs(i, j, grid, visited, item, offset);
                    set.add(item.toString());
                }
            }
        }
        return set.size();
    }

    private static void dfs(int row, int col, int[][] grid, boolean[][] visited, StringBuilder item, int offset) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == 1) {
            visited[row][col] = true;

            item.append(row * ROW + col - offset);
            item.append("#");
            dfs(row + 1, col, grid, visited, item, offset);
            dfs(row, col + 1, grid, visited, item, offset);
            dfs(row - 1, col, grid, visited, item, offset);
            dfs(row, col - 1, grid, visited, item, offset);
        }
    }


    public static void main(String[] args) {
        int[][] input = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1}
        };

        System.out.println(numDistinctIslands(input));
    }
}
