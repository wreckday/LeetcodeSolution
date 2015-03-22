/**
 * Created by Mellon on 3/22/15.
 *
 * Balanced Binary Tree :
 *
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
  of the two subtrees of every node never differ by more than 1.

 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        if(helper(root)>-1)
            return true;

        return false;
    }


    private int helper(TreeNode root){
        if(root==null)
            return 0 ;
        // we want to know the tree's depth info and is it balanced
        // so if the subtree is not balanced, we return -1
        // or return the depth
        int left =  helper(root.left);
        int right = helper(root.right);

        if(left<0 || right<0)
            return -1;

        if(Math.abs(left-right)>1)
            return -1;

        return Math.max(helper(root.left),helper(root.right))+1;
    }
}
