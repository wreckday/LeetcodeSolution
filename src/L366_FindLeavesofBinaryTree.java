import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, find all leaves and then remove those leaves.
 Then repeat the previous steps until the tree is empty.

 Example:
 Given binary tree
        1
       / \
     2   3
    / \
   4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Remove the leaves [4, 5, 3] from the tree

     1
    /
   2
 2. Remove the leaf [2] from the tree

    1
 3. Remove the leaf [1] from the tree

 []
 Returns [4, 5, 3], [2], [1].


 *
 * Created by Mellon on 8/11/17.
 */
public class L366_FindLeavesofBinaryTree {
    /*
    For this question we need to take bottom-up approach.
    The key is to find the height of each node.


    I used a helper function to return the height of current node.
    According to the definition,
    the height of leaf is 0.
    h(node) = 1 + max(h(node.left), h(node.right)).
    The height of a node is also the its index in the result list (res).
    For example, leaves, whose heights are 0, are stored in res[0].
    Once we find the height of a node, we can put it directly into the result.
    * */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode node, List<List<Integer>> res){
        if(null==node)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if(res.size()<level+1)  res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
}
