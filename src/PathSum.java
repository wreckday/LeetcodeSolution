/**
 * Created by Mellon on 3/15/15.
 *
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
        5
       / \
      4   8
     /   / \
   11   13  4
  /  \       \
 7    2       1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    // time:O(n)
    // space:O(logN)

    // consider three situations
    //   1. empty node
    //   2. leaf node   (no left and right sub-tree)
    //   3. normal node (has left and right sub-tree)
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int sum){
        //1. empty node
        if(root==null) return false;
        //2. leaf node   (no left and right sub-tree)
        if(root.left == null && root.right == null && sum == root.val)
            return true;
        //3. normal node (has left and right sub-tree)
        return helper(root.left, sum-root.val) || helper(root.right, sum-root.val);
    }
}
