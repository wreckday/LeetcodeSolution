import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mellon on 3/22/15.
 *
 *
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int lastNum = 1;
        int curNum = 0;

        List<Integer> temp = new ArrayList<Integer>();

        while(!queue.isEmpty()){
            TreeNode parent = queue.remove();
            temp.add(parent.val);

            lastNum--;
            if(parent.left!=null){
                queue.add(parent.left);
                curNum++;
            }

            if(parent.right!=null){
                queue.add(parent.right);
                curNum++;
            }

            if(lastNum == 0){
                lastNum=curNum;
                curNum=0;

                res.add(temp);

                temp = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
