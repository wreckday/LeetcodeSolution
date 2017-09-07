import java.util.Stack;

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

//    let's try Preorder first. First we save left child and right child.
// Then we can safely flatten this node. Then left and right.

     class Solution {
        TreeNode pre=null;
        public void flatten(TreeNode root) {
            if(root==null) return;
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(pre == null) {
                pre = root;
            }else {
                pre.right = root;
                pre.left = null;
                pre = root;
            }
            flatten(left);
            flatten(right);
        }
    }
/*
Postorder is a little tricky and not easy to come up.
Because the order we flatten will not change the relationship of remaining nodes we do not extra pointers.
* */
 class Solution2 {
    TreeNode pre=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre = root;
    }
}


     public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        int v = 6;
    }

}
