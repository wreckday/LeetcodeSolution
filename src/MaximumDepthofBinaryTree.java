import java.util.LinkedList;

/**
 * Created by Mellon on 3/15/15.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int level){
        if(root == null)
            return level;
        return Math.max(helper(root.left, level+1), helper(root.right, level+1));
    }
 /*------------------------------------------------------------------------------
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
*/

    public int maxDepth(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return 0;

        queue.add(root);

        int curNum=0;
        int lastNum=1;
        int level = 0;
        while(!queue.isEmpty()){
            TreeNode parent = queue.remove();
            lastNum--;
            if(parent.left!=null){
                queue.add(parent.left);
                curNum++;
            }
            if(parent.right!=null){
                queue.add(parent.right);
                curNum++;
            }
            if(lastNum==0){
                lastNum=curNum;
                curNum=0;
                level++;
            }
        }
        return level;
    }
}
