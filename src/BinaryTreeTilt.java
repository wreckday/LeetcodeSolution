/**
 * Created by Mellon on 4/24/17.
 */
public class BinaryTreeTilt {
    private static int sum = 0;
    public static int findTilt(TreeNode root) {
        if(root == null) return sum;
        helper(root);
        return sum;
    }

    private static int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int diff = Math.abs(left - right);
        sum = sum + diff;
        return left + right + node.val;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        System.out.println(findTilt(n1));
    }
}
