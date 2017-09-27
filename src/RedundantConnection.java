import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mellon on 9/23/17.
 */
public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        // 有效的樹 就是沒有loop, 如果有loop 就加入此pair, 最後答案是最後一個pair
        Redundant_QuickUnion redundant_quickUnion = new Redundant_QuickUnion(edges);
        List<int[]> result = new ArrayList<>();
        for (int[] pair : edges) {
            if (redundant_quickUnion.connected(pair[0], pair[1])) {
                result.add(pair);
            } else {
                redundant_quickUnion.union(pair[0], pair[1]);
            }
        }
        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
//        int[][] input = {
//                {1, 2}, {1, 3}, {2, 3}
//        };

        //Common.printIntegerArray(findRedundantConnection(input));

        int[][] input2 = {
                {2, 3}, {5, 2}, {1, 5}, {4, 2}, {4, 1}
        };
        int[] result2 = findRedundantConnection(input2);
        Common.printIntegerArray(result2);
    }
}


class Redundant_QuickUnion {
    private Map<Integer, Integer> map;

    public Redundant_QuickUnion(int[][] edges) {
        map = new HashMap<>();
    }

    public int find(int p) {
        while (map.containsKey(p) && p != map.get(p)) {
            p = map.get(p);  // chase parent's pointers until reach root
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);   // check if p and q have same root
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        map.put(j, i);   // change root of p point to root of q
    }
}