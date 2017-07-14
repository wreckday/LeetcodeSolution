/**
 Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree
 along the parent-child connections.
 The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,

    1
     \
      3
     / \
    2   4
        \
        5
 Longest consecutive sequence path is 3-4-5, so return 3.

     2
      \
       3
      /
     2
    /
   1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 * Created by Mellon on 2/3/17.
 */
public class L298_BinaryTreeLongestConsecutiveSequence {
    /*
    因为要找最长的连续路径，我们在遍历树的时候需要两个信息，
    一是目前连起来的路径有多长，二是目前路径的上一个节点的值。
    我们通过递归把这些信息代入，然后通过返回值返回一个最大的就行了。
    这种需要遍历二叉树，然后又需要之前信息的题目思路都差不多
    */
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findLongest(root, 0, root.val - 1);
    }

    private int findLongest(TreeNode root, int length, int preVal){
        if(root == null){
            return length;
        }
        // 判断当前是否连续
        int currLen = preVal + 1 == root.val ? length + 1 : 1;
        // 返回当前长度，左子树长度，和右子树长度中较大的那个
        return Math.max(
                currLen,
                Math.max(findLongest(root.left, currLen, root.val), findLongest(root.right, currLen, root.val)));
    }
}
