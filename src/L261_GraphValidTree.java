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

            // find
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

    public static void main(String[] args){
        int[][] input = {{0,1}, {0,2}, {1, 2}};
        int[][] input2 = {{0, 1}, {1, 2}, {2, 3}, {1, 4}};
        int[][] input3 = {{2, 3}, {2, 1}, {1, 3}};
        boolean result = validTree(3, input);
        System.out.println(result);
    }
}
