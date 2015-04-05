/**
 * Created by Mellon on 3/15/15.

 Same Tree

 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class isSameTree {
    //时间复杂度是O(n)，空间复杂度是O(logn)。
    // 1）左边为空而右边不为空；（2）左边不为空而右边为空；（3）左边值不等于右边值
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;

        //1）左边为空而右边不为空；（2）左边不为空而右边为空；
        if(p==null || q==null) return false;

        //3）左边值不等于右边值
        if(p.val!=q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
