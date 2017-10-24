/**
 * Created by Mellon on 3/15/15.
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

public class ValidateBinarySearchTree {
    //   第一種解法
    public boolean isValidBST_Long(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    // 第一種解法 的 improve -----  利用null 和integer object 來處理Integer.MAX_VALUE
    private boolean help(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        return (low == null || root.val > low) && (high == null || root.val < high)
                && help(root.left, low, root.val) && help(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }



    /*********  SECOND METHOD---------------*/
    public static int last = Integer.MIN_VALUE;

    public static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        // check / recurse left
        if (!isValidBST2(root.left))
            return false;

        // check current
        if (root.val <= last)
            return false;
        last = root.val;

        // check / recurese right
        if (!isValidBST2(root.right))
            return false;

        return true;
    }


    /*---------THIRD  METHOD-------------------------------------------------------------------*/
    public static int index = 0;

    public static void copyBST(TreeNode root, int[] array) {
        if (root == null) return;
        copyBST(root.left, array);
        array[index] = root.val;
        index++;
        copyBST(root.right, array);
    }

    public static boolean isValidBST3(TreeNode root) {
        int[] array = new int[1000000];
        copyBST(root, array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return false;
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}