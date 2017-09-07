import java.util.*;

/**
 * Created by Mellon on 8/5/17.
 */
public class TwoSumIV_InputisaBST {
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private static boolean helper(TreeNode root, int k, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(k-root.val)){
            return true;
        }else {
            set.add(root.val);
        }
        return helper(root.left, k, set)|| helper(root.right, k, set);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(findTarget(n1, 9));
        int v = 6;
    }
}
