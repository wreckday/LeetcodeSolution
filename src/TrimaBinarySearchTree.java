/**
 Given a binary search tree and the lowest and highest boundaries as L and R,
 trim the tree so that all its elements lies in [L, R] (R >= L).
 You might need to change the root of the tree,
 so the result should return the new root of the trimmed binary search tree.


 * Created by Mellon on 9/5/17.
 */
public class TrimaBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R){
        if(root==null) return null;
        // 分三種情況,
        if(root.val < L)      //當root.val小於lower界限時, 就要改成繼續trim root 的右子樹,
            return trimBST(root.right, L, R);
        else if(root.val > R)    //當root.val大於higher界限時, 就要改成繼續trim root 的左子樹,
            return trimBST(root.left, L, R);
        else {                  // 當root.val 介於lower界限和higher 界限時,  要繼續往左右子樹trim 然後 return root
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
