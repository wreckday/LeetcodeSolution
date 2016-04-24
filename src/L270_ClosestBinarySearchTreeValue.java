/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:
 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * Created by Mellon on 4/3/16.
 */
public class L270_ClosestBinarySearchTreeValue {
    static double min_diff;
    static int node_val;
    public static int closestValue(TreeNode root, double target) {
        min_diff = Math.abs(root.val-target);
        node_val = root.val;
        helper(root, target);
        return node_val;
    }

    private static void helper(TreeNode root, double target){
        if(root == null)
            return;

        if(Math.abs(root.val-target)<=min_diff){
            min_diff = Math.abs(root.val-target);
            node_val = root.val;
        }

        if(target > root.val){
            helper(root.right, target);
        }else{
            helper(root.left, target);
        }
    }

    public static void main(String[] args){
        /*
                8
               / \
              5  10
             /\  /\
            4 7 9  15
        * */
//        TreeNode n1 = new TreeNode(8);
//        TreeNode n2 = new TreeNode(5);
//        TreeNode n3 = new TreeNode(10);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(7);
//        TreeNode n6 = new TreeNode(9);
//        TreeNode n7 = new TreeNode(15);
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;
//
//
//        TreeNode t1 = new TreeNode(0);

        TreeNode c1 = new TreeNode(1500000000);
        TreeNode c2 = new TreeNode(1400000000);
        c1.left = c2;

        //System.out.print(closestValue(n1, 4.8));
        //System.out.print(closestValue(t1, 2147483648.0));
        System.out.print(closestValue(c1, -1500000000.0));
    }
}
