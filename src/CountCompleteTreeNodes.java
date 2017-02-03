/**
 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far left as possible.
 It can have between 1 and 2h nodes inclusive at the last level h.

 * Created by Mellon on 10/13/16.
 */
public class CountCompleteTreeNodes {
    // time O(log N * log N)There are at most lgn divisions,
    // and lgn to calculate height within each division. So lgn * lgn
    public int countNodes(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root){
        if(root==null) return 0;

        int l = getLeft(root) + 1;
        int r = getRight(root) + 1;

        if(l==r) {
            return (2<<(l-1)) - 1;
        } else {
            return helper(root.left) + helper(root.right) + 1;
        }
    }

    private int getLeft(TreeNode root) {
        int count = 0;
        while(root.left!=null) {
            root = root.left;
            count++;
        }
        return count;
    }

    private int getRight(TreeNode root) {
        int count = 0;
        while(root.right!=null) {
            root = root.right;
            count++;
        }
        return count;
    }
}
