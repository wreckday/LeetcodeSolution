import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mellon on 3/21/15.
 *
 * Binary Tree Inorder Traversal :
 *

  Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
            1
             \
             2
            /
           3
     return [1,3,2]
 */
public class BinaryTreeInorderTraversal {
    //其实就是用一个栈来模拟递归的过程。所以算法时间复杂度也是O(n)，空间复杂度是栈的大小O(logn)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                // point : only this line is different compared to preorder traversal
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    //*****************************************************************************************************
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root){
        if(root == null)
            return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}
