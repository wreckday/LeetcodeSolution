/**
 * Created by Mellon on 6/14/15.
 */
public class countTreeNodes {
    public static int countTreeNodes(TreeNode root){
        return helper(root);
    }

    private static int helper(TreeNode root){
        if(root == null)
            return 0;
        return helper(root.left) + helper(root.right)+1;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.print(countTreeNodes(n1));
    }
}
