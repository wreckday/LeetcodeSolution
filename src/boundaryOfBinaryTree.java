import java.util.*;

/**
 * Created by Mellon on 3/25/17.
 */
public class BoundaryOfBinaryTree {
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        helper(root, res);

        return res;
    }
    private static void helper(TreeNode root, List<Integer> res){
        if(root == null )return;
        if(root.left == null && root.right==null){
            res.add(root.val);
        }
        helper(root.left, res);
        helper(root.right, res);
    }


    private static List<TreeNode> leftBoundary(TreeNode root) {
        List<TreeNode> b = new ArrayList<>();
        for(TreeNode node = root; node != null;) {
            b.add(node);
            if(node.left != null) {
                node = node.left;
            }
            else if(node.right != null) {
                node = node.right;
            }
            else {
                node = null;
            }
        }
        return b;
    }

    private static List<TreeNode> rightBoundary(TreeNode root) {
        List<TreeNode> b = new ArrayList<>();
        for(TreeNode node = root; node != null; ) {
            b.add(0, node);
            if(node.right != null) {
                node = node.right;
            }
            else if(node.left != null) {
                node = node.left;
            }
            else {
                node = null;
            }
        }
        return b;
    }

    private static void bottomBoundary(TreeNode root, List<TreeNode> b) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                b.add(root);
            }
            else {
                bottomBoundary(root.left, b);
                bottomBoundary(root.right, b);
            }
        }
    }

    private static List<Integer> mergeBoundary(List<TreeNode> ...b) {
        List<Integer> boundary = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        for(List<TreeNode> ct : b) {
            for(TreeNode node : ct) {
                if(!visited.contains(node)) {
                    visited.add(node);
                    boundary.add(node.val);
                }
            }
        }
        return boundary;
    }

    public static List<Integer> boundaryOfBinaryTree2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> bottom = new ArrayList<>();
        bottomBoundary(root, bottom);

        return mergeBoundary(Arrays.asList(root), leftBoundary(root.left), bottom, rightBoundary(root.right));
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n5.left=n7;
        n5.right=n8;
        n6.left=n9;
        n6.right=n10;
        List<Integer> res = boundaryOfBinaryTree(n1);
        int v = 6;
    }
}
