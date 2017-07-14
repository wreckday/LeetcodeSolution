import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mellon on 2/11/17.
 */
public class FindLeftMostElement {
    public static int findLeftMostNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 0;
        int last = 1;
        int val = root.val;
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();
            val = parent.val;
            last--;
            if(parent.right != null) {
                queue.add(parent.right);
                cur++;
            }
            if(parent.left != null){
                queue.add(parent.left);
                cur++;
            }
            if(last==0){
                last = cur;
                cur = 0;
            }
        }
        return val;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        int res = findLeftMostNode(n1);
        System.out.print(res);
    }
}
