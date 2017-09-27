import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mellon on 8/5/17.
 */
public class PrintBinaryTree {

    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res)
            Arrays.fill(arr, "");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res)
            ans.add(Arrays.asList(arr));
        return ans;
    }

    public static void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        int mid = l + (r - l) / 2;
        res[i][mid] = "" + root.val;
        fill(res, root.left, i + 1, l, mid - 1);
        fill(res, root.right, i + 1, mid + 1, r);
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /*

        Time: O(h*2eh)
        space: O(h*2eh)
     */

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(5);
//        TreeNode n4 = new TreeNode(3);
//        TreeNode n5 = new TreeNode(4);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n2.left = n4;
//        n4.left = n5;
//
//        List<List<String>> res = printTree(n1);
//************************************************
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);


        n1.left = n2;
        List<List<String>> res = printTree(n1);
        int v = 5;


    }
}
