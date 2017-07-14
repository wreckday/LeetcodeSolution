import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mellon on 3/18/17.
 */
public class ConvertBSTtoGreaterTree {
    private static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.right);

        int copyRootVal = root.val;

        root.val = root.val+sum;
        sum = sum + copyRootVal;
        dfs(root.left);
    }




    // right->root->left.   we can inorder traverse then reverse it to get right -> root-> left
    private static List<TreeNode> list=new ArrayList<>();
    public static TreeNode convertBSTReverse(TreeNode root) {
        dfs1(root);
        Collections.reverse(list);
        int sum=0;
        for(TreeNode node: list){
            sum+=node.val;
            node.val=sum;
        }
        return root;
    }

    private static void dfs1(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(-4);
        TreeNode n5 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(convertBST(n1));
    }
}
