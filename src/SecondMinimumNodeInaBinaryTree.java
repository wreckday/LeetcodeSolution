/**
 * Created by Mellon on 9/5/17.
 */
public class SecondMinimumNodeInaBinaryTree {
    public static int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;

        int l = (root.left != null && root.left.val != root.val) ? root.left.val :findSecondMinimumValue(root.left);
        int r = (root.right != null && root.right.val != root.val) ? root.right.val :findSecondMinimumValue(root.right);

        if(l == -1 || r == -1) return Math.max(l, r);
        return Math.min(l, r);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.print(findSecondMinimumValue(n1));

    }
}
