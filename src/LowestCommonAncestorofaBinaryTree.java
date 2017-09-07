/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Created by Mellon on 7/26/15.
 */
public class LowestCommonAncestorofaBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q)
            return root;

        TreeNode x = helper(root.left, p, q);
        TreeNode y = helper(root.right, p, q);

        // p and q are in different sides
        if (x != null && y != null)
            return root;

        if (x == null)
            return y;
        else
            return x;

    }

    //**********************  Extension (keys may not present)
    public static boolean isP_node_present;
    public static boolean isQ_node_present;

    public static TreeNode lowestCommonAncestorExtension(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helperEx(root, p, q);
        if (res != null && isP_node_present && isQ_node_present)
            return res;
        return null;
    }

    public static TreeNode helperEx(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p) {
            isP_node_present = true;
            return root;
        }

        if (root == q) {
            isQ_node_present = true;
            return root;
        }

        TreeNode x = helperEx(root.left, p, q);
        TreeNode y = helperEx(root.right, p, q);

        // p and q are in different sides
        if (x != null && y != null)
            return root;

        if (x == null)
            return y;
        else
            return x;

    }

    public static void main(String[] args) {
        /*
              5
            /   \
           3    7
          / \   /
         9  2  4
           \
           0

        */
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.right = n5;
        n2.left = n6;

        //case 1:
        //TreeNode an = lowestCommonAncestor(root, n1, n5);
        //case 2:
//        TreeNode an = lowestCommonAncestor(root, n3, n4);
//        TreeNode an2 = lowestCommonAncestorExtension(root, n3, n4);
//        System.out.println(an.val);
//        System.out.println(an2.val);

        TreeNode nodeNotPresent = new TreeNode(1000);
        TreeNode an3 = lowestCommonAncestor(root, n3, nodeNotPresent);
        TreeNode an4 = lowestCommonAncestorExtension(root, n3, nodeNotPresent);

        System.out.println("Ans3: " + an3.val);

        System.out.println("Ans4: " + an4);
    }
}
