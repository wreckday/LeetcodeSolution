import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mellon on 8/19/17.
 */
public class MaximumWidthofBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while(!queue.isEmpty()){

            while(!queue.isEmpty() && queue.getLast()==null){
                queue.pollLast();
            }
            max = Math.max(max, queue.size());
            int parentSize = queue.size();
            for(int i=0;i<parentSize;i++){
                TreeNode parent = queue.poll();
                if(parent!=null){
                    queue.add(parent.left);
                    queue.add(parent.right);
                }else {
                    queue.add(null);
                    queue.add(null);
                }

            }
        }
        return max;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n9 = new TreeNode(9);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left=n3;
        n1.right=n2;
        n3.left=n5;
        n2.right=n9;
        n5.left=n6;
        n9.right=n7;
        System.out.println(widthOfBinaryTree(n1));
    }
}
