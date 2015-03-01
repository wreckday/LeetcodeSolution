import java.util.HashMap;

/**
 * Created by Mellon on 2/28/15.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    // time : O(n)
    // Space : a map =>  O(n)

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length==0)
            return null;
        // build map to get index from inorder via preL
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    public TreeNode helper(int[] inorder, int inL, int inR,
                           int[] postorder, int postL, int postR,
                           HashMap<Integer, Integer> map){

        if(inL>inR || postL>postR)
            return null;
        // we can know the root and build it from preorder[preL]
        TreeNode root = new TreeNode(postorder[postR]);
        // inorder can help us divide left subtree and right tree via knowing the index,
        // and we can get the index from the value of map we just build, the key is preorder[preL].
        int index = map.get(postorder[postR]);

        // 畫圖舉例
        //        postL                  postR
        // post:     7, 8, 3, 10, 12, 5,  1
        // inorder:  7, 3, 8,  1, 10, 5, 12
        //          inL      index       intR
        root.left = helper(inorder, inL, index-1, postorder, postL, postL-1+(index-inL), map);
        root.right = helper(inorder, index+1, inR, postorder, postR-(inR-index), postR-1, map);

        return root;
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
}
