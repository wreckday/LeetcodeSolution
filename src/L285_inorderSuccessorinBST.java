import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * Note: If the given node has no in-order successor in the tree, return null.
 * <p>
 * Created by Mellon on 6/22/16.
 */
public class L285_inorderSuccessorinBST {


    public static TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }


    public static TreeNode successor2(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(suc);
        helper(root, p, treeNodeList);
        return treeNodeList.get(0);
    }

    private static void helper(TreeNode root, TreeNode p, List<TreeNode> suc) {
        // base case
        if (root == null) return;
        if (root == p) {
            if (root.right != null) {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                suc.remove(0);
                suc.add(temp);
            }
            return;
        }
        if (p.val < root.val) {
            suc.remove(0);
            suc.add(root);
            helper(root.left, p, suc);
        }

        if (p.val > root.val) {
            helper(root.right, p, suc);
        }
    }

    /*

                15
               /  \
    case 2   8    20
           /  \
 case 1  6    13
        /     / \
       4    12  14   case 3
          /
         9

    * */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(15);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(12);
        TreeNode n8 = new TreeNode(14);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n5.left = n7;
        n5.right = n8;
        n7.left = n9;

        // case 1
        System.out.println(successor(n1, n4).val);
        System.out.println(successor2(n1, n4).val);
        // case 2
        System.out.println(successor(n1, n2).val);
        System.out.println(successor2(n1, n2).val);


        // case 3
        System.out.println(successor(n1, n8).val);
        System.out.println(successor2(n1, n8).val);
    }

    /*
    To find a successor, you just need to find the smallest one that is larger than the given value
    since there are no duplicate values in a BST.
    * */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return succ;
    }

}