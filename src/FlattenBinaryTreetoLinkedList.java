/**
 * Created by Mellon on 3/21/15.
 * // 算法的复杂度时间上还是一次遍历，O(n)
 *
 *
 * Given a binary tree, flatten it to a linked list in-place.

 For example,Given
             1
            / \
           2   5
          / \   \
         3   4   6
 The flattened tree should look like:
         1
          \
           2
            \
             3
              \
               4
                \
                 5
                  \
                   6
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root == null)
            return null;

        // point: need to record right tree for later using.
        TreeNode rtree = root.right;

        if(root.left!=null){
            root.right = root.left;
            root.left = null;
            root = helper(root.right);
        }

        if(rtree!=null){
            root.right = rtree;
            root = helper(root.right);
        }
        return root;
    }
}
