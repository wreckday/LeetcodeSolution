import java.util.Stack;

/**
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 Hint:
 Try to utilize the property of a BST.
 What if you could modify the BST node's structure?
 The optimal runtime complexity is O(height of BST).

 *
 * Created by Mellon on 10/15/16.
 */
public class KthSmallestElementinaBST {
    //    time complexity O(n)
    // stack
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);    // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if(++count == k) return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }

    // recursive
    public int kthSmallestRecurse(TreeNode root, int k) {
        TreeNode result = new TreeNode(k); // using tree.val to store k, and tree.left to point to kth element
        recurse(root, result);
        return result.left.val;
    }

    public void recurse(TreeNode root, TreeNode result) {
        if(root == null || result.left != null) return;
        recurse(root.left, result);
        result.val = result.val - 1;
        if(result.val == 0) {
            result.left = root; // kth element
        }
        recurse(root.right, result);
    }
}
