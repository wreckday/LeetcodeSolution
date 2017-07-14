

/**
 * Created by Mellon on 6/17/17.
 */
public class MaximumDistanceinArrays {
    /*
    we can keep on traversing over the arrays in the list and keep a track of the maximum distance found so far.
    To do so, we keep a track of the element with minimum value and the one with maximum value found so far.
    For every new array, a considered, we find the distance a[n-1]-min and max_val−a[0]
    to compete with the maximum distance found so far.
    Here, n refers to the number of elements in the current array, a.
    Further, we need to note that the points min_val and max_val
    both need not always contribute to the maximum distance found till now.
    But, such points could help in maximizing the distance in the future.
    Thus, max_val and min_val contribute to the global maximum and minimum values found till now,
    irrespective of the points considered for the contribution in the maximum distance found till now.
    * */
    public static int maxDistance(int[][] list) {
        int res = 0;
        int min_val = list[0][0];
        int max_val = list[0][list[0].length - 1];

        for (int i = 1; i < list.length; i++) {
            res = Math.max(res, Math.max(Math.abs(list[i][list[i].length - 1] - min_val), Math.abs(max_val - list[i][0])));
            min_val = Math.min(min_val, list[i][0]);
            max_val = Math.max(max_val, list[i][list[i].length - 1]);
        }
        return res;
    }
    /*
    Complexity Analysis
Time complexity : O(n)O(n). We traverse over the listlist of length nn once only.
Space complexity : O(1)O(1). Constant extra space is used.
    * */

    public static void main(String[] args) {
        int[][] input = {
                {-2},
                {-3, -2, 1}
        };

        System.out.println(maxDistance(input));
    }
}
