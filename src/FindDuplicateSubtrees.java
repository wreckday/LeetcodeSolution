import java.util.*;

/**
 * Created by Mellon on 8/1/17.
 */
public class FindDuplicateSubtrees {

 /*
    題目要求求出重複的subtree, 那我們直覺得就要想到可以從bottom to top 建造 sequence of 子樹的結構, 用hashMap 來存sequence.
    要注意的是當結點是null時, 仍然要把null節點存成#, 如此一來才可以得到正確的sequence, 因為給一個sequence 是無法得到一個唯一的樹,
    有可能會有不同樹, 但是同樣的sequence
    time : O(N)
    space : O(N)
    key : serialize tree as string
 * */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        helper(root, new HashMap<>(), res);
        return res;
    }

    public static String helper(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + helper(cur.left, map, res) + "," + helper(cur.right, map, res);
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
