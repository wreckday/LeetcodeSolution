/**
 *
 There are a row of n houses, each house can be painted with one of the k colors.
 The cost of painting each house with a certain color is different.
 You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n col k cost matrix.
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
        if (costs.length == 0) {
            return 0;
        }
        int min1 = 0, min2 = 0, index1 = -1;

        for (int i = 0; i < costs.length; i++) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;

            for (int j = 0; j < costs[0].length; j++) {
                int cost = costs[i][j] + (j != index1 ? min1 : min2);

                if (cost < m1) {           // cost < m1 < m2
                    m2 = m1; m1 = cost; idx1 = j;

                } else if (cost < m2) {    // m1 < cost < m2
                    m2 = cost;
                }
            }

            min1 = m1; min2 = m2; index1 = idx1;
        }
        return min1;
    }

    public static void main(String[] args){
        int[][] costs1 = {{1, 3}};
        int[][] costs = {{1, 3, 5},{2, 3, 1},{4, 1, 2}};
        System.out.print(minCostII(costs1));
    }

    /*
    The idea is similar to the problem Paint House I,
    for each house and each color,
    the minimum cost of painting the house with that color
    should be the minimum cost of painting previous houses,
    and make sure the previous house doesn't paint with the same color.

    To solve this DP problem:

    If there's no constraint, we choose min cost for each house.
    Since house[i] and house[i - 1] cannot have the same color j, we should choose 2nd min color for house[i - 1].
    If we choose the 3rd min color for house[i - 1], we might miss potential min cost.
    min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n.
    Since current row only relies on last row for getting mins and avoiding same color, O(1) space is enough.
    * */
}
