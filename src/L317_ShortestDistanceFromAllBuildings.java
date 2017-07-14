import java.util.LinkedList;
import java.util.Queue;

/**
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

 Note:
 There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 *
 * Created by Mellon on 3/28/17.
 */
public class L317_ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];  // total distance from every building to empty land(0)
        int[][] reach = new int[m][n]; // count for already reached building
        int houseNum = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {  // from every building, we do BFS to every empty land
                    houseNum++;
                    int level = 0;
                    boolean[][] visited = new boolean[m][n];
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i*n+j);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int t=0; t<size; t++) {
                            int cur = queue.poll();
                            int x = cur/n;
                            int y = cur%n;
                            for (int[] dir : directions) {
                                int xnew = x + dir[0];
                                int ynew = y + dir[1];
                                if (xnew>=0 && xnew<m && ynew>=0 && ynew<n && !visited[xnew][ynew] && grid[xnew][ynew]==0) {
                                    queue.offer(xnew*n+ynew);
                                    visited[xnew][ynew] = true;
                                    dist[xnew][ynew] += level+1;
                                    reach[xnew][ynew]++;
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        // choose the min distance
        int minDist = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]==0 && reach[i][j] == houseNum) {
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
        return minDist==Integer.MAX_VALUE? -1 : minDist;
    }

    /*
    Start from each building, do bfs to calculate the shortest distance to each empty land which it can reach.
Repeat this process for all buildings. we can get the sum of shortest distance from every '0' to all reachable buildings.
This value is stored in 'distance[][]'.

Notice that there are empty lands that can not be reached from some buildings.
like (0, 2) below, it can not be reached from the building (0, 0) and (2, 2)

1 1 0

0 0 1

0 0 1

Therefore, we also count how many building each '0' can be reached. It is stored in reach[][].
This can be done during the BFS. We also need to count how many total buildings are there in the matrix,
which is stored in 'buildingNum'.

Our building should be placed at those empty places which can reach all buildings,
that is to say, reach[i][j] == buildingNum
we choose the shortest distances among all these empty places.
Be careful the case where there are only buildings and no empty lands, like [[1]].
so shortest distance at last is still Integer.MAX_VALUE should be turned to -1
    * */
}

