import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Mellon on 7/8/17.
 */
public class AverageofLevelsinBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 0;
        int last = 1;
        long sum = 0;
        double copyLast = 1;
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();

            last--;
            sum+=parent.val;
            if(parent.left !=null){
                queue.add(parent.left);
                cur++;
            }

            if(parent.right!=null){
                queue.add(parent.right);
                cur++;
            }

            if(last==0){

                res.add(sum/copyLast);
                copyLast = cur;
                sum = 0;
                last = cur;
                cur = 0;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        TreeNode n1 = new TreeNode(Integer.MAX_VALUE);
        TreeNode n2 = new TreeNode(Integer.MAX_VALUE);
//        TreeNode n3 = new TreeNode(5);
        root.left=n1;
        root.right=n2;
//        n1.right=n3;
        List<Double> res = averageOfLevels(root);
        int v = 5;
        // 1, 2.5, 5
    }


}
