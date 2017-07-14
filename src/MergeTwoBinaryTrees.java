/**
 * Created by Mellon on 6/10/17.
 */
public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
    /*
    Complexity Analysis

Time complexity : O(m). A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.

Space complexity : O(m). The depth of the recursion tree can go upto m in the case of a skewed tree.
In average case, depth will be O(logm)
    *
    * */

    public static void main(String[] args){
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(3);
//        TreeNode n3 = new TreeNode(2);
//        TreeNode n4 = new TreeNode(5);
//
//        n1.left=n2;
//        n1.right=n3;
//        n2.left=n4;
//
//        TreeNode b1 = new TreeNode(2);
//        TreeNode b2 = new TreeNode(1);
//        TreeNode b3 = new TreeNode(3);
//        TreeNode b4 = new TreeNode(4);
//        TreeNode b5 = new TreeNode(7);
//
//        b1.left=b2;
//        b1.right=b3;
//        b2.right=b4;
//        b3.right = b5;
//        TreeNode treeNode = mergeTrees(n1, b1);

        TreeNode b1 = new TreeNode(1);
        TreeNode treeNode = mergeTrees(null, b1);
        System.out.print(treeNode);
    }
}
