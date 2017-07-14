import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mellon on 6/17/17.
 */
public class AddOneRowtoTree {
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode newTreeNode = new TreeNode(v);
            newTreeNode.left = root;
            return newTreeNode;
        }
        helper(root, v, d);
        return root;
    }

    private static void helper(TreeNode node, int v, int d){
        if(node == null) return;
        if(d==2){
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = node.left;
            newRight.right = node.right;
            node.left = newLeft;
            node.right = newRight;
            return;
        }
        helper(node.left, v, d-1);
        helper(node.right, v, d-1);
    }

    public static TreeNode addOneRowBFS(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode newTreeNode = new TreeNode(v);
            newTreeNode.left = root;
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int row = 1;
        int last_count = 1;
        int current_count = 0;
        while (!queue.isEmpty()) {
            if(row==d-1){
                TreeNode parent = queue.poll();
                if (parent.left != null) {
                    TreeNode tempLeftTree = parent.left;
                    parent.left = new TreeNode(v);
                    parent.left.left = tempLeftTree;
                }else {
                    parent.left = new TreeNode(v);
                }

                if(parent.right != null){
                    TreeNode tempRightTree = parent.right;
                    parent.right = new TreeNode(v);
                    parent.right.right = tempRightTree;
                }else {
                    parent.right = new TreeNode(v);
                }
            }else{
                TreeNode parent = queue.poll();
                if (parent.left != null) {
                    queue.offer(parent.left);
                    current_count++;
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                    current_count++;
                }
                last_count--;
                if(last_count==0){
                    last_count = current_count;
                    current_count=0;
                    row++;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        TreeNode result = addOneRow(n1, 1, 1);
        int v=9;
//
//
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//
//
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//
//        TreeNode result = addOneRow(n1, 5, 4);

    }
}
