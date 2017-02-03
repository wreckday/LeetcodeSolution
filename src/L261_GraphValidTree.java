//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//        For example:
//
//        Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
//        Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
//        Show Hint
//        Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in
//

/**
 * Created by Mellon on 4/17/16.
 */
public class L261_GraphValidTree {
    // union find -- quick union (quadratic)
    public static boolean validTree(int n, int[][] edges) {

        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i;
        }

        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];

            // quadratic find root
            while(x!=nums[x]){
                x = nums[x];
            }
            while(y!=nums[y]){
                 y = nums[y];
            }
            if(x == y) return false;

            // union
            nums[y]=x;
        }

        return edges.length == n - 1;
    }

    public static boolean validTree2(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        // or it could be a separate components
        if (n - 1 != edges.length) {
            return false;
        }

        QuickUnion uf = new QuickUnion(n);
        for (int i = 0; i < edges.length; i++) {
            // check if it's a cycle
            if (uf.connected(edges[i][0], edges[i][1])) {  // find(p)==find(q)
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }

    public static void main(String[] args){
        int[][] input = {{0,1}, {0,2}, {1, 2}};
        int[][] input2 = {{0, 1}, {1, 2}, {2, 3},{1, 3}, {1, 4}};
        int[][] input3 = {{2, 3}, {2, 1}, {1, 3}};
        boolean result = validTree(5, input2);
        boolean result2 = validTree2(5, input2);
        System.out.println(result);
        System.out.println(result2);
    }
}
