import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 10/3/15.
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();

        if(root==null)
            return res;

        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
    }

    private static void helper(TreeNode root, StringBuilder sb, List<String> res){
        if(root == null){
            res.add(sb.toString());
            return;
        }

        if(sb.toString().equals(""))
            sb.append(root.val);
        else{
            sb.append("->");
            sb.append(root.val);
        }

        helper(root.left, sb, res);
        helper(root.right, sb, res);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        binaryTreePaths(root);
    }
}
