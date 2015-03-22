/**
 * Created by Mellon on 3/21/15.
 *
 * Convert Sorted Array to Binary Search Tree :
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
    //时间复杂度还是一次树遍历O(n)，
    //总的空间复杂度是栈空间O(logn)加上结果的空间O(n)，额外空间是O(logn)，总体是O(n)。
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length==0)
            return null;

        return helper(num, 0, num.length-1);
    }

    public TreeNode helper(int[] num, int l, int r){
        // don't forget base case
        if(l>r)
            return null;

        int m = (l+r)/2;
        TreeNode root = new TreeNode(num[m]);
        root.left = helper(num, l, m-1);
        root.right = helper(num, m+1, r);
        return root;
    }
}
