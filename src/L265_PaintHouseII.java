/**
 *
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color 0;
 costs[1][2] is the cost of painting house 1 with color 2, and so on...
 Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Follow up:
 Could you solve it in O(nk) runtime?
 *
 * Created by Mellon on 5/14/16.
 */
public class L265_PaintHouseII {
    public static int minCostII(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }

        for(int i=1; i<costs.length; i++){
            for(int j=0;j<costs[0].length;j++){
                costs[i][j] = costs[i][j] + helper(costs[i-1], j);
            }
        }
        int n = costs.length-1;

        int min = Integer.MAX_VALUE;
        for(int i=0;i<costs[n].length;i++){
            min = Math.min(min, costs[n][i]);
        }

        return min;
    }

    private static int helper(int[] previous, int currentColorIndex){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<previous.length;i++){
            if(i==currentColorIndex) continue;
            min = Math.min(min, previous[i]);
        }
        return min;
    }

    public static void main(String[] args){
        int[][] costs1 = {{1, 3}};
        int[][] costs = {{1, 3, 5},{2, 3, 1},{4, 1, 2}};
        System.out.print(minCostII(costs1));
    }
}
