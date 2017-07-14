import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 Serialization is the process of converting a data structure or object into a sequence of bits
 so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree.
 There is no restriction on how your serialization/de-serialization algorithm should work.
 You just need to ensure that a binary tree can be serialized to a string
 and this string can be de-serialized to the original tree structure.

 For example, you may serialize the following tree

        1
       / \
      2   3
         / \
        4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 * Created by Mellon on 6/28/16.
 */

class Codec2{
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    //DFS -- pre-order traverse
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);

    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}


public class SerializeandDeserializeBinaryTree {


    public static void main(String[] args){
        /*      1
               / \
              2   3
               \
               5
        */
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        root.left=n1;
        root.right=n2;
        n1.right=n3;

        Codec2 codec = new Codec2();
        String decodeTree = codec.serialize(root);
        System.out.println(decodeTree);
        codec.deserialize(decodeTree);
    }
}
