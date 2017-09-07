import java.util.*;

/**
 * Created by Mellon on 8/1/17.
 */
public class FindDuplicateSubtrees {
    // time : O(N)
    // space : O(N)
    // key : serialize tree as string, value: count
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public static String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }

    public static void main(String[] args){
        /*
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4

        * */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;

        List<TreeNode> res = findDuplicateSubtrees(n1);
        int v = 5;


     }

}
