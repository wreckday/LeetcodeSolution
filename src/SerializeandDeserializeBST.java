import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 Serialization is the process of converting a data structure or object into a sequence of bits
 so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree.
 There is no restriction on how your serialization/deserialization algorithm should work.
 You just need to ensure that a binary search tree can be serialized to a string
 and this string can be deserialized to the original tree structure.

 The encoded string should be as compact as possible.

 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.

 *
 *
 * Created by Mellon on 8/14/17.
 */
    /*
    ＃＃＃思路：perOrder traverse the tree for serialization. For deserialization,
    utilize split function and use queue to store values and traverse to build a tree
    一開始沒有考慮到數字可能超過一個位數, 所以也沒有用分隔號隔開, 後來發現錯了。應該要用queue 去存string 轉換為數字
    ＃＃＃時間複雜度： both O(n)
    ＃＃＃空間複雜度： O(n) for queue + recursive call space
    ＃＃＃相關題： preorder traverse. Serialize and Deserialize Binary Tree
    ＃＃＃哪些條件提示我想到了解法：
    */

class CodecTree {
    private static final String SPLITER = ",";
    private static final String NULL = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder();
        serialize(root, st);
        return st.toString();
    }
    public void serialize(TreeNode root, StringBuilder st) {
        if (root == null) st.append(NULL + SPLITER);
        else {
            st.append(root.val + SPLITER);
            serialize(root.left, st);
            serialize(root.right, st);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITER)));
        return reconPreOrder(queue);
    }

    public TreeNode reconPreOrder(Queue<String> queue){
        String val = queue.poll();
        if (val.equals(NULL)) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}

public class SerializeandDeserializeBST {


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        CodecTree codecTree = new CodecTree();
        String code = codecTree.serialize(n1);
        System.out.print(code);
        TreeNode decode = codecTree.deserialize(code);
        int v = 9;
    }
}
