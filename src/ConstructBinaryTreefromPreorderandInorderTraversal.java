import java.util.HashMap;

/**
 * Created by Mellon on 2/28/15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    // time : O(n)
    // Space : a map =>  O(n)

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length==0)
            return null;
        // build map to get index from inorder via preL
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode helper(int[] preorder, int preL, int preR,
                           int[] inorder, int inL, int inR,
                           HashMap<Integer, Integer> map){

        if(preL>preR || inL>inR)
            return null;
        // we can know the root and build it from preorder[preL]
        TreeNode root = new TreeNode(preorder[preL]);
        // inorder can help us divide left subtree and right tree via knowing the index,
        // and we can get the index from the value of map we just build, the key is preorder[preL].
        int index = map.get(preorder[preL]);

        root.left = helper(preorder, preL+1, index-inL+preL, inorder, inL, index-1, map);
        root.right = helper(preorder, index-inL+preL+1, preR, inorder, index+1, inR, map);

        return root;
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
}
