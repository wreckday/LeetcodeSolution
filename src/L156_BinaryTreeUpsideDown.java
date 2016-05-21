/**
 * Created by Mellon on 4/8/16.
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

    For example:
    Given a binary tree {1,2,3,4,5},

     1
    / \
   2   3
  / \
 4  5

 return the root of the binary tree [4,5,2,#,#,3,1].
        4
       / \
      5   2
          /\
         3 1
 *
 *
 */
public class L156_BinaryTreeUpsideDown {
    public static TreeNode UpsideDownBinaryTreeIterate(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;

        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        printTree(t1);
        System.out.println("");

        TreeNode newTree = upsideDownBinaryTree(t1);

        printTree(newTree);

    }

    private static void printTree(TreeNode root){
        if(root==null) return;
        System.out.print(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
