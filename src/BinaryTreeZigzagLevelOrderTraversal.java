import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mellon on 3/21/15.
 *
 * Binary Tree Zigzag Level Order Traversal :
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

            3
           / \
          9  20
          /  \
         15   7
    [3],
    [20,9],
    [15,7]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    // BFS_____________________________________________________________
    //时间复杂度是O(n)，空间复杂度最坏是两层的结点，所以数量级还是O(n)（满二叉树最后一层的结点是n/2个）
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(root);
        int level = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            // odd
            List<Integer> temp = new ArrayList<Integer>();
            if(level%2==1){
                while(!stack1.isEmpty()){
                    TreeNode parent = stack1.pop();
                    temp.add(parent.val);

                    if(parent.left!=null){
                        stack2.push(parent.left);
                    }

                    if(parent.right!=null){
                        stack2.push(parent.right);
                    }
                }
            }else{
                while(!stack2.isEmpty()){
                    TreeNode parent = stack2.pop();
                    temp.add(parent.val);

                    if(parent.right!=null){
                        stack1.push(parent.right);
                    }

                    if(parent.left!=null){
                        stack1.push(parent.left);
                    }
                }
            }
            level++;
            res.add(temp);
        }
        return res;
    }
    //________________________________________________________________________
    //DFS

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        travel(result, root, 0);
        return result;
    }

    private void travel(List<List<Integer>> result, TreeNode curr, int level) {
        if (curr == null) {
            return;
        }

        if (result.size() <= level) {
            List<Integer> newLevel = new LinkedList<Integer>();
            result.add(newLevel);
        }

        //reference to current list, directly manipulate
        List<Integer> collection  = result.get(level);
        //odd reverse output, oven output normally
        if (level % 2 == 0) {
            collection.add(curr.val);
        }else {
            collection.add(0, curr.val);
        }

        //dfs left and right respectively;
        travel(result, curr.left, level + 1);
        travel(result, curr.right, level + 1);
    }
    //总体思想用DFS去遍历每一层，需要注意的地方就是Zigzag 要求奇数层逆序输出，偶数层正场输出，
    //用LinkedList来存每一层的结果，因为可以从头插入，也可以从未插入，
    //插入复杂度为O(1)。总体复杂度为O(n)，最后在用个ArrayList存每一层的结果就好了。
}
