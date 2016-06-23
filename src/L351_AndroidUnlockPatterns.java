/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.

 Rules for a valid pattern:
 Each pattern must connect at least m keys and at most n keys.
 All the keys must be distinct.
 If the line connecting two consecutive keys in the pattern passes through any other keys,
 the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.

 The order of keys used matters.

 | 1 | 2 | 3 |
 | 4 | 5 | 6 |
 | 7 | 8 | 9 |
 Invalid move: 4 - 1 - 3 - 6
 Invalid move: 4 - 1 - 9 - 2
 Valid move: 2 - 4 - 1 - 3 - 6
 6 - 5 - 4 - 1 - 9 - 2

 * Created by Mellon on 5/23/16.
 */
public class L351_AndroidUnlockPatterns {
    private static int[][] dirs1 = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{-1,-1},{1,-1},{-1,1},
            {2,1},{2,-1},{-2,-1},{-2,1},{1,2},{-1,2},{1,-2},{-1,-2},
    };
    private static int[][] dirs2 = new int[][]{
            {2,0},{0,2},{-2,0},{0,-2},// need check middle visited[i+dir[0]/2][j+dir[1]/2]
    };
    private static int[][] dirs3 = new int[][]{
            {2,2},{-2,-2},{2,-2},{-2,2}// need check visited[1,1]
    };
    private static int count=0;
    public static int numberOfPatterns(int m, int n) {
        boolean[][] visited = new boolean[3][3];
        for (int i=0; i <3; ++i){
            for (int j=0; j <3; ++j){
                visited[i][j] = true;
                dfs(m,n,1,visited,i,j);
                visited[i][j] = false;
            }
        }
        return count;
    }
    private static void dfs(int m, int n, int level, boolean[][] visited, int i, int j){
        if (level>=m && level<=n){
            ++count;
            if (level>=n)
                return;
        }
        for (int[] dir : dirs1){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x>=0 && x<3 && y>=0 && y<3 && !visited[x][y]){
                visited[x][y] = true;
                dfs(m,n,level+1,visited,x,y);
                visited[x][y] = false;
            }
        }
        for (int[] dir : dirs2){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x>=0 && x<3 && y>=0 && y<3 && !visited[x][y] && visited[i+dir[0]/2][j+dir[1]/2]){
                visited[x][y] = true;
                dfs(m,n,level+1,visited,x,y);
                visited[x][y] = false;
            }
        }
        for (int[] dir : dirs3){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x>=0 && x<3 && y>=0 && y<3 && !visited[x][y] && visited[1][1]){
                visited[x][y] = true;
                dfs(m,n,level+1,visited,x,y);
                visited[x][y] = false;
            }
        }
    }

    public static void main(String[] args){
        int m = 1;
        int n = 2;
        int res = numberOfPatterns(m, n);
        System.out.println(res);
    }
}
