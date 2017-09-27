import java.util.*;

/**
 * Created by Mellon on 9/9/17.
 */
public class CutOffTreesforGolfEvent {
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int killedTreeCount = 0;


    public static int cutOffTree(List<List<Integer>> forest) {
        List<List<Integer>> trees = new ArrayList<>();
        int row = forest.size();
        int col = forest.get(0).size();

        // find every tree and sort
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) {
                    List<Integer> temp = new ArrayList<>();
                    int code = i * col + j;
                    temp.add(code);
                    temp.add(forest.get(i).get(j));
                    trees.add(temp);
                }
            }
        }

        Collections.sort(trees, (a, b) -> a.get(1) - b.get(1));
        int step = 0;
        int from = 0;
        for (List<Integer> tree : trees) {
            int cur = killTree(forest, from, tree.get(0), row, col);
            if(cur == -1) {
                return -1;
            }else {
                killedTreeCount++;
                step += cur;
                int tree_i = tree.get(0) / col;
                int tree_j = tree.get(0) % col;
                forest.get(tree_i).set(tree_j, 1);
                from = tree.get(0);
            }
        }

        if(killedTreeCount != trees.size()) return -1;

        return step;
    }

    // return workload
    private static int killTree(List<List<Integer>> forest, int start, int end, int row, int col) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        if(start == 0 && start == end) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int parentSize = queue.size();
            step++;
            for (int i = 0; i < parentSize; i++) {
                int parent = queue.poll();
                int parent_i = parent / col;
                int parent_j = parent % col;

                for (int[] d : dir) {
                    int x = parent_i + d[0];
                    int y = parent_j + d[1];
                    int code = x * col + y;
                    if (x < 0 || y < 0 || x >= row || y >= col || visited.contains(code)) continue;
                    visited.add(code);
                    if (forest.get(x).get(y) == 1) { // can walk
                        queue.offer(code);
                    } else if (forest.get(x).get(y)  > 1) { // tree
                        if (code == end)
                            return step;
                        else
                            queue.offer(code);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

//        List<Integer> list1 = Arrays.asList(54581641, 64080174, 24346381, 69107959);
//        List<Integer> list2 = Arrays.asList(86374198, 61363882, 68783324, 79706116);
//        List<Integer> list3 = Arrays.asList(668150, 92178815, 89819108, 94701471);
//        List<Integer> list4 = Arrays.asList(83920491, 22724204, 46281641, 47531096);
//        List<Integer> list5 = Arrays.asList(89078499, 18904913, 25462145, 60813308);

        List<Integer> list1 = Arrays.asList(9, 12, 5, 14);
        List<Integer> list2 = Arrays.asList(17, 11, 13, 15);
        List<Integer> list3 = Arrays.asList(2, 20, 19, 21);
        List<Integer> list4 = Arrays.asList(16, 4, 7, 8);
        List<Integer> list5 = Arrays.asList(18, 3, 6, 10);

        List<List<Integer>> forest = Arrays.asList(list1, list2, list3, list4, list5);
        System.out.println(cutOffTree(forest));

    }
}
