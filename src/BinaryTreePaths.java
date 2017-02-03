import java.util.ArrayList;
import java.util.List;
/*

Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:
["1->2->5", "1->3"]

*/
/**
 * Created by Mellon on 10/3/15.
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root != null)
            findPaths(root, String.valueOf(root.val), res);

        return res;
    }

    private static void findPaths(TreeNode n, String path, List<String> res){

        if(n.left == null && n.right == null)
            res.add(path);

        if(n.left != null)
            findPaths(n.left, path+"->"+n.left.val, res);

        if(n.right != null)
            findPaths(n.right, path+"->"+n.right.val, res);
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
