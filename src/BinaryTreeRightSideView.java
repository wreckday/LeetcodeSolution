import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 7/5/15.
 */
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();


        helper(root, res);
        return res;
    }

    private static void helper(TreeNode root, List<Integer> res){
        if(root == null)
            return;

        res.add(root.val);

        if(root.right!=null){
            helper(root.right, res);
        }else if(root.left!=null){
            helper(root.left, res);
        }
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        List<Integer> res = rightSideView(n1);
        for(Integer e:res){
            System.out.println(e);
        }
    }
}
