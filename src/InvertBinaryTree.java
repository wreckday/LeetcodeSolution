/**
 Invert a binary tree.

      4
    /   \
   2     7
  / \   / \
 1   3 6   9

      to

      4
    /   \
   7     2
  / \   / \
 9   6 3   1


 * Created by Mellon on 10/13/16.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root != null)
            helper(root);
        return root;
    }

    private static void helper(TreeNode root){
        if(root == null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        helper(root.left);
        helper(root.right);
    }
}
