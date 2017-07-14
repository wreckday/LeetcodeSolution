import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, you need to compute the length of the diameter of the tree.
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.

 Example:
 Given a binary tree
     1
    / \
   2   3
  / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Created by Mellon on 3/18/17.
 */
public class DiameterofBinaryTree {
    //Diameter of tree is defined as A longest path or route between any two nodes in a tree. The path may or may not for through the root.
    // Maximum(Diameter of left subtree, Diameter of right subtree, Longest path between two nodes which passes through the root.)
    // n2
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftH + rightH, Math.max(leftDiameter, rightDiameter));
    }

    public static int getHeight(TreeNode root) {
        if(root==null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    // time complexity O(N)

    public static int diameterOfBinaryTree_N(TreeNode root) {
        // res.get(0) is the node's diameter
        List<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(root, res);
        return res.get(0);
    }

    // dfs function returns the height of the node.
    public static int dfs(TreeNode root, List<Integer> res) {
        if(root==null) return 0;
        int leftH = dfs(root.left, res);
        int rightH = dfs(root.right, res);

        res.set(0, Math.max(leftH + rightH, res.get(0)));

        return Math.max(leftH, rightH) + 1;
    }



    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(diameterOfBinaryTree(n1));
        System.out.println(diameterOfBinaryTree_N(n1));
    }
}
