import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 3/15/15.
 *
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
         5
        / \
       4   8
      /   / \
    11   13  4
    /  \       \
   7    2       1

 return
 [
   [5,4,11,2],
   [5,8,4,5]
 ]

 */
public class PathSumII {
    //这里的时间复杂度仍然只是一次遍历O(n)，而空间复杂度则取决于满足条件的路径和的数量（假设是k条），则空间是O(klogn)。
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> item, List<List<Integer>> res){
        // empty node
        if(root == null) return;

        // leaf node
        if(root.left == null && root.right == null && root.val == sum){
            item.add(root.val);
            res.add(new ArrayList<Integer>(item));
            item.remove(item.size()-1);
            return;
        }

        item.add(root.val);

        helper(root.left, sum-root.val, item, res);
        helper(root.right, sum-root.val, item, res);

        item.remove(item.size()-1);
        // after recursion we remove the element to recover the state of the item before recursive call
    }
}
