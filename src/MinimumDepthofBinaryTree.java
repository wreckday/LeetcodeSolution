import java.util.LinkedList;

/**
 * Created by Mellon on 3/21/15.
 *
 * Minimum Depth of Binary Tree:
 *
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth2(TreeNode root) {
        if(root == null)
            return 0;
        //只是这道题因为是判断最小深度，所以必须增加一个叶子的判断（因为如果一个节点如果只有左子树或者右子树，我们不能取它左右子树中小的作为深度，因为那样会是0，我们只有在叶子节点才能判断深度，
        if(root.left == null)
            return minDepth(root.right)+1;
        if(root.right == null)
            return minDepth(root.left)+1;

        return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
    }


    public int minDepth(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return 0;

        queue.add(root);

        int curNum=0;
        int lastNum=1;
        int level = 0;
        while(!queue.isEmpty()){
            TreeNode parent = queue.remove();
            lastNum--;

            if(parent.left == null && parent.right == null)
                return level+1;

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
