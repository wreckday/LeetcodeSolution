/**
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:
        10
       /  \
      5   15
     / \   \
    1   8   7
 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.
 *
 *
 * Created by Mellon on 4/3/16.
 */
class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
    int size;
    int lower;
    int upper;

    Result(int size, int lower, int upper) {
        this.size = size;
        this.lower = lower;
        this.upper = upper;
    }
}

public class L333_LargestBSTSubtree {
// O(n)
    static int max = 0;
    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }
        traverse(root);
        return max;
    }

    private static Result traverse(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = traverse(root.left);
        Result right = traverse(root.right);

        // not valid
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }

        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left=n2;
        int res = largestBSTSubtree(n1);
        System.out.println(res);

    }
}


//https://leetcode.com/discuss/86027/share-my-o-n-java-code-with-brief-explanation-and-comments