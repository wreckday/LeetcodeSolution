import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 8/5/17.
 */
public class PrintBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    public static List<List<String>> printTree(TreeNode root) {
        int h = maxDepth(root);
        List<List<String>> res = new ArrayList<>();
        // 0, 3, 7, 15
        int rootIndex = (int) Math.pow(2, h - 1) - 1;
        int theMostRightIndex = rootIndex*2;

        helper(root, res, 0, rootIndex, theMostRightIndex, h);

        return res;
    }

    private static void helper(TreeNode root, List<List<String>> res, int level, int rootIndex, int theMostRightLimit, int h) {
        if (level == h || root == null) return;

        if (res.size() - 1 < level) { // list doesn't exist, create a new
            List<String> temp = new ArrayList<>();
            for (int i = 0; i <= theMostRightLimit; i++) {
                if (i == rootIndex) temp.add(String.valueOf(root.val));
                else temp.add("");
            }
            res.add(temp);
        } else { // list exists, so just set the value to rootIndex
            for (int i = 0; i <= rootIndex; i++) {
                if (i == rootIndex) res.get(level).set(rootIndex, String.valueOf(root.val));
            }
        }

        int offSet = (int) Math.pow(2, (h - level -1)-1);
        int leftIndex = rootIndex - offSet;
        if (leftIndex >= 0)
            helper(root.left, res, level + 1, leftIndex, theMostRightLimit, h);

        int rightIndex = rootIndex + offSet;
        if (rightIndex <= theMostRightLimit)
            helper(root.right, res, level + 1, rightIndex, theMostRightLimit, h);
    }

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
