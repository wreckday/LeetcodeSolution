import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.
 *
 * Created by Mellon on 3/19/17.
 */
public class _01Matrix {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix.size() == 0 || matrix.get(0).size() == 0) return matrix;
        int m = matrix.size();
        int n = matrix.get(0).size();

        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> dis = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dis.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    dis.get(i).add(0);
                    q.offer(i * n + j);
                } else {
                    dis.get(i).add(-1);
                }
            }
        }

        int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int node = q.poll();
            int x = node / n;
            int y = node % n;
            for (int i = 0; i < 4; i++) {
                int nx = x + dxy[i][0];
                int ny = y + dxy[i][1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && dis.get(nx).get(ny) == -1) {
                    dis.get(nx).set(ny, dis.get(x).get(y) + 1);
                    q.offer(nx * n + ny);
                }
            }
        }

        return dis;
    }
}
