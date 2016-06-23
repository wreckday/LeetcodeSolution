import java.util.Stack;

/**
 Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.

 Follow up:
 Could you do it using only constant space complexity?
 *
 * Created by Mellon on 6/10/16.
 */
public class L255_VerifyPreorderSequenceinBinarySearchTree {
    // ex. 9, 5, 3, 6, 12, 10, 13
    /*
              9
             /  \
           5    12
          /\   / \
         3 6  10 13
    * */
    public static boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;

    }
    /*
    Kinda simulate the traversal,
    keeping a stack of nodes (just their values) of which we're still in the left subtree.
    If the next number is smaller than the last stack value,
    then we're still in the left subtree of all stack nodes,
    so just push the new one onto the stack. But before that,
    pop all smaller ancestor values,
    as we must now be in their right subtrees (or even further, in the right subtree of an ancestor).
    Also, use the popped values as a lower bound, since being in their right subtree
    means we must never come across a smaller number anymore.
    */
}
