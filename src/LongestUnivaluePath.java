/**
 * Created by Mellon on 9/30/17.
 */
public class LongestUnivaluePath {
    static int max = 0;
    public static int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    public static int helper(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;

        int left = helper(root.left);
        int right = helper(root.right);

        left = (root.left!=null && root.left.val==root.val?left:0);
        right = (root.right!=null && root.right.val==root.val?right:0);
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(longestUnivaluePath(n1));
    }
}
