import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mellon on 2/25/17.
 */
public class MinimumAbsoluteDifferenceinBST {
    private static int min = Integer.MAX_VALUE;
    public static int getMinimumDifferenceMe(TreeNode root) {
        if(root == null ) return -1;
        helper(root);
        return min;
    }

    private static void helper(TreeNode root){
        if(root == null) return;
        find(root);
        helper(root.left);
        helper(root.right);
    }

    private static void find(TreeNode root){
        if(root == null) return;
        TreeNode temp = root;
        if(temp.left!=null){
            temp = temp.left;
            while(temp.right!=null){
                temp = temp.right;
            }
            min = Math.min(root.val-temp.val, min);
        }
        temp = root;
        if(temp.right!=null){
            temp = temp.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            min = Math.min(Math.abs(root.val-temp.val), min);
        }
    }

    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nodes.size();i++){
            for(int j=i+1;j<nodes.size();j++)
                min = Math.min(min, Math.abs(nodes.get(i)- nodes.get(j)));
        }
        return min;
    }
    static ArrayList<Integer> nodes = new ArrayList<>();
    public static void dfs(TreeNode root){
        if(root == null) return;
        nodes.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);

        TreeNode t3 = new TreeNode(5);

        TreeNode t5 = new TreeNode(3);


        t1.right = t3;
        t3.left = t5;
        //t2.right = t5;

        System.out.println(getMinimumDifference(t1));
    }
}
