/**
 * Created by Mellon on 3/15/15.
 * Sum Root to Leaf Numbers:
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

    1
  /  \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
    //time: O(n); Space: O(logN)
//   consider three situations
//   1. empty node
//   2. leaf node   (no left and right sub-tree)
//   3. normal node (has left and right sub-tree)
    public static int sumNumbers(TreeNode root) {

        return helper(root,0);
    }

    private static int helper(TreeNode root, int sum)
    {   // 1. empty node
        if(root == null){
            return 0;
        }

        // 2. leaf node
        if(root.left==null && root.right==null)
            return sum*10+root.val;
        //3. normal node
        return helper(root.left, root.val + sum*10) + helper(root.right, root.val + sum*10);
    }
}
