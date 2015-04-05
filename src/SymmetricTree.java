import java.util.LinkedList;

/**
 * Created by Mellon on 3/15/15.
 *
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:
 */
//只需要对相应结点进行比较即可。一颗树对称其实就是看左右子树是否对称，一句话就是左同右，右同左，结点是对称的相等
//  (1）左边为空而右边不为空；
// （2）左边不为空而右边为空；
// （3）左边值不等于右边值。根据这几个条件在遍历时进行判断即可。
//  算法的时间复杂度是树的遍历O(n)，空间复杂度同样与树遍历相同是O(logn)

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q){

        if(p==null && q==null)
            return true;

        //1）左边为空而右边不为空；（2）左边不为空而右边为空
        if(p==null || q==null)
            return false;

        //（3）左边值不等于右边值
        if(p.val != q.val)
            return false;

        return helper(p.left, q.right) && helper(p.right, q.left);
    }

    //---------------------------------------------iterate   using BFS-----------------------------------------

    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left == null || root.right == null)
            return false;

        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(root.left);
        q2.add(root.right);

        while(!q1.isEmpty() && !q2.isEmpty())
        {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if(n1.val != n2.val)
                return false;

            if(n1.left == null && n2.right != null || n1.left != null && n2.right == null)
                return false;

            if(n1.right == null && n2.left != null || n1.right != null && n2.left == null)
                return false;

            if(n1.left != null && n2.right != null)
            {
                q1.add(n1.left);
                q2.add(n2.right);
            }

            if(n1.right != null && n2.left != null)
            {
                q1.add(n1.right);
                q2.add(n2.left);
            }
        }
        return true;
    }
}
