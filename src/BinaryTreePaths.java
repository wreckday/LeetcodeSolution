import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 10/3/15.
 */
public class BinaryTreePaths {
    static List<String> res = new ArrayList<String>();

    public static List<String> binaryTreePaths(TreeNode root) {

        if(root != null)
            findPaths(root, String.valueOf(root.val));

        return res;
    }

    private static void findPaths(TreeNode n, String path){

        if(n.left == null && n.right == null)
            res.add(path);

        if(n.left != null)
            findPaths(n.left, path+"->"+n.left.val);

        if(n.right != null)
            findPaths(n.right, path+"->"+n.right.val);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        root.left=n1;
        root.right=n2;
        n1.right=n3;
        List<String> res = binaryTreePaths(root);
        Common.printStringList(res);
    }
}
