import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 Note:
 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

 Follow up:
 Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 Hint:
 1. Consider implement these two helper functions:
 　　i. getPredecessor(N), which returns the next smaller node to N.
 　　ii. getSuccessor(N), which returns the next larger node to N.
 2. Try to assume that each node has a parent pointer, it makes the problem much easier.
 3. Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
 4. You would need two stacks to track the path in finding predecessor and successor node separately.

 *
 * Created by Mellon on 1/17/17.
 */
public class L272_ClosestBinarySearchTreeValueII {
    /*
    Following the hint, I use a predecessor stack and successor stack.
    I do a log(n) traversal to initialize them until I reach the null node.
    Then I use the getPredecessor and getSuccessor method to pop k closest nodes and update the stacks.

    Time complexity is O(klogn), since k BST traversals are needed and each is bounded by O(logn) time.
    Note that it is not O(logn + k) which is the time complexity for k closest numbers in a linear array.

    Space complexity is O(klogn), since each traversal brings O(logn) new nodes to the stack.
    * */
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<Integer>();
        // populate the predecessor and successor stacks
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            if (target <= curr.val) {
                succ.push(curr);
                curr = curr.left;
            } else {
                pred.push(curr);
                curr = curr.right;
            }
        }
        while (k > 0) {
            if (pred.empty() && succ.empty()) {
                break;
            } else if (pred.empty()) {
                result.add( getSuccessor(succ) );
            } else if (succ.empty()) {
                result.add( getPredecessor(pred) );
            } else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
                result.add( getPredecessor(pred) );
            } else {
                result.add( getSuccessor(succ) );
            }
            k--;
        }
        return result;
    }

    private static int getPredecessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.left;
        while (p != null) {
            st.push(p);
            p = p.right;
        }
        return popped.val;
    }

    private static int getSuccessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.right;
        while (p != null) {
            st.push(p);
            p = p.left;
        }
        return popped.val;
    }

    public static void main(String[] args) {
        /*
                8
               / \
              5  10
             /\  /\
            4 7 9  15
        * */
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(15);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.print(closestKValues(n1, 4.8,3));
    }

    /*
    Input: root node, key
    output: predecessor node, successor node

    1. If root is NULL
        then return
    2. if key is found then
        a. If its left subtree is not null
            Then predecessor will be the right most
            child of left subtree or left child itself.
        b. If its right subtree is not null
            The successor will be the left most child
            of right subtree or right child itself.
        return
    3. If key is smaller then root node
            set the successor as root
            search recursively into left subtree
        else
            set the predecessor as root
            search recursively into right subtree
    * */
}
