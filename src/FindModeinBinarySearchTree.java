/**
 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
    1
     \
      2
     /
    2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space?
 (Assume that the implicit stack space incurred due to recursion does not count).
 *
 * Created by Mellon on 2/6/17.
 */
public class FindModeinBinarySearchTree {
    private static int max;
    private static int currentVal;
    private static int currentCount;
    private static int modeCount;

    public static int[] findMode(TreeNode root) {

        if(root == null) return null;
        // 1. first pass to find highest frequency occurred count(max), and modeCount;
        inorder(root);
        // 2. second pass to find occurrence of current node is equal to max,
        //    add the node value to result
        int[] result = new int[modeCount];
        currentCount=0;
        secondPass(root, result);
        return result;
    }

    // inorder traverse
    private static void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(root.val == currentVal){
            currentCount++;
        }else{
            if(currentCount > max) {
                max = currentCount;
                modeCount = 1;
            } else if( currentCount == max){
                modeCount ++;
            }
            currentVal = root.val;
            currentCount = 0;
        }
        inorder(root.right);
    }

    private static void secondPass(TreeNode root, int[] result){
        secondPass(root.left, result);
        if(root.val == currentVal){
            currentCount ++;
        } else {
            if(currentCount == max) {
                result[modeCount] = currentVal;
                currentVal = root.val;
                currentCount = 0;
                modeCount++;
            }
        }
        secondPass(root.right, result);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;



        Common.printIntegerArray(findMode(n1));
    }
}
