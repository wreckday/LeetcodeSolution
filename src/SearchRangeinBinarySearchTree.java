import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
 Find all the keys of tree in range k1 to k2.

 i.e. print all x such that k1<=x<=k2 and x is a key of given BST.
 Return all the keys in ascending order.

 *
 * Created by Mellon on 8/18/17.
 */
public class SearchRangeinBinarySearchTree {
    /*
    ＃＃＃思路： 一開始我的想法是用inorder traverse, 走過每個節點, 然後去檢查是否在範圍裡。另外一種方法是preorder 二分法, 如果根節點
    範圍裡, 就要往左右繼續走下去, 如果根節點大於k2 就要往左邊繼續走, 如果根節點小於k1 就要往又繼續走。
    ＃＃＃時間複雜度： O(k) k在k1, k2 之間
    ＃＃＃空間複雜度： recursive call
    ＃＃＃相關題： inorder traveral. validate binary search tree
    ＃＃＃哪些條件提示我想到了解法：Binary Search Tree 節點是有順序的 讓我想到可以借由比較根的值往左或往右走
    */


    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        helper(root, k1, k2, res);
        Collections.sort(res);
        return res;
    }

    private static void helper(TreeNode root, int k1, int k2, List<Integer> res){
        if(root==null) return;

        if(root.val>=k1 && root.val<=k2) {
            res.add(root.val);
            helper(root.left, k1, k2, res);
            helper(root.right, k1, k2, res);
        }else if(root.val<=k2){
            helper(root.right, k1, k2, res);
        }else if(root.val>=k1){
            helper(root.left, k1, k2, res);
        }
    }


    public static List<Integer> searchRangeTraverse(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                TreeNode current = stack.pop();
                if(current.val>=k1&&current.val<=k2){
                    res.add(current.val);
                }
                root = current.right;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;

        List<Integer> res = searchRange(n1, 0, 4);
        Common.printIntegerList(res);

    }
}
