import java.util.*;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root." Besides the root,
 * each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Created by Mellon on 4/26/17.
 */
public class HouseRobberIII {
    // time O(n^2)
    public static int rob(TreeNode root) {
        return helper(root);
    }

    private static int helper(TreeNode root){
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
/*    Step II -- Think one step further   time : O(n)
    In step I, we only considered the aspect of "optimal substructure", but think little about the possibilities of overlapping of the subproblems.
    For example, to obtain rob(root),
    we need rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left), rob(root.right.right);
    but to get rob(root.left), we also need rob(root.left.left), rob(root.left.right), similarly for rob(root.right).
    The naive solution above computed these sub problems repeatedly, which resulted in bad time performance.
    Now if you recall the two conditions for dynamic programming: "optimal substructure" + "overlapping of subproblems",
    we actually have a DP problem. A naive way to implement DP here is to use a hash map to record the results for visited subtrees.

    And here is the improved solution: */

    public static int robFaster(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private static int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    /*   time O(n)
    If we were able to maintain the information about the two scenarios for each tree root,
    let's see how it plays out. Redefine rob(root) as a new function which will return an array of two elements,
    the first element of which denotes the maximum amount of money that can be robbed if root is not robbed,
    while the second element signifies the maximum amount of money robbed if it is robbed.
    * */

    public static int robMoreInformation(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);

        n1.left=n2;
        n1.right=n3;
        n2.right=n4;
        n3.right = n5;
        int res = rob(n1);
        System.out.println(res);
    }
}
