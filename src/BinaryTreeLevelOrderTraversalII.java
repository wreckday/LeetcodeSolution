import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mellon on 3/22/15.
 * Binary Tree Level Order Traversal II:
 *
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
     /    \
    15    7

 return its bottom-up level order traversal as:
 [
    [15,7],
    [9,20],
    [3]
 ]
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        // queue
        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
        cur.add(root);

        while(!cur.isEmpty()){
            LinkedList<TreeNode> parents = cur;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            // to empty cur
            cur = new LinkedList<TreeNode>();
            for(TreeNode p : parents){

                temp.add(p.val);

                if(p.left != null)
                    cur.add(p.left);

                if(p.right !=null)
                    cur.add(p.right);
            }
            res.add(temp);
        }

        Collections.reverse(res);
        return res;
    }
//***************************    use stack  ****************************************

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        // queue
        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();

        // stack
        LinkedList<List<Integer>> resStack = new LinkedList<List<Integer>>();

        cur.add(root);

        while(!cur.isEmpty()){
            LinkedList<TreeNode> parents = cur;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            // to empty cur
            cur = new LinkedList<TreeNode>();
            for(TreeNode p : parents){

                temp.add(p.val);

                if(p.left != null)
                    cur.add(p.left);

                if(p.right !=null)
                    cur.add(p.right);
            }
            resStack.push(temp);
        }

        while(resStack.size()>0){
            res.add(resStack.pop());
        }

        return res;
    }
}
