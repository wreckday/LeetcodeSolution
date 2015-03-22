import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mellon on 3/21/15.
 * Binary Tree Preorder Traversal :
 *
 Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
        1
         \
          2
         /
        3
 return [1,2,3].
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //其实就是用一个栈来模拟递归的过程。所以算法时间复杂度也是O(n)，空间复杂度是栈的大小O(logn)。实现的代码如下：
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root == null)
            return res;

        while(root!=null || !stack.isEmpty()){
            if(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;

            }else{
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
    // recursion_____________________________________________________________________________________________
    //算法的时间复杂度是O(n), 而空间复杂度则是递归栈的大小，即O(logn)。代码如下：
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null)
            return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }
}
