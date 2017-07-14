import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Mellon on 2/11/17.
 */
public class FindLargestElementinEachRow {
    public static int[] findValueMostElement(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 0;
        int last = 1;
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();
            max = Math.max(max, parent.val);
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
                res.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
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
        int[] res = findValueMostElement(n1);
        Common.printIntegerArray(res);
    }
}
