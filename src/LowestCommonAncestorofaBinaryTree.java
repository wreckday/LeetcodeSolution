/**
 * Created by Mellon on 7/26/15.
 */
public class LowestCommonAncestorofaBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public static TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }

        if(root == p || root == q)
            return root;

        TreeNode x = helper(root.left, p, q);
        TreeNode y = helper(root.right, p, q);

        // p and q are in different sides
        if(x!=null && y!=null)
            return root;

        if(x == null)
            return y;
        else
            return x;

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(4);

        root.left=n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.right = n5;
        n2.left = n6;


        TreeNode an = lowestCommonAncestor(root, n1, n5);
        System.out.print(an.val);
    }
}