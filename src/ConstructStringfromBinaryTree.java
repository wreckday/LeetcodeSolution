import java.util.List;

/**
 * Created by Mellon on 6/3/17.
 */
public class ConstructStringfromBinaryTree {
    public static String tree2str(TreeNode t) {
        if(t==null) return "";
        StringBuilder sb = new StringBuilder();
        helper(sb , t);
        if(sb.length()>2){
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private static void helper(StringBuilder sb, TreeNode root){
        sb.append("(");
        sb.append(root.val);
        if(root.left != null)
            helper(sb, root.left);
        else if(root.right!=null)
            sb.append("()");

        if(root.right != null)
            helper(sb, root.right);

        sb.append(")");
    }

    public static void main(String[] args){
//        /*
//               1
//             /   \
//            2     3
//           /
//          4
//
//        * */
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        n1.left=n2;
//        n1.right=n3;
//        n2.left=n4;
//        System.out.println(tree2str(n1)); //    1(2(4))(3)
//
//
//        /*
//             1
//           /   \
//          2     3
//           \
//           4
//
//        * */
//        TreeNode na1 = new TreeNode(1);
//        TreeNode na2 = new TreeNode(2);
//        TreeNode na3 = new TreeNode(3);
//        TreeNode na4 = new TreeNode(4);
//        na1.left=na2;
//        na1.right=na3;
//        na2.right=na4;
//        System.out.println(tree2str(na1));    //  "1(2()(4))(3)"
//
//        TreeNode nb1 = new TreeNode(1);
//        System.out.println(tree2str(nb1));

        // [-1,-2,null,-3,null,-4]
                /*
             -1
            /
          -2
         /
       -3
       /
     -4
        * */
        TreeNode nc1 = new TreeNode(-1);
        TreeNode nc2 = new TreeNode(-2);
        TreeNode nc3 = new TreeNode(-3);
        TreeNode nc4 = new TreeNode(-4);
        nc1.left=nc2;
        nc2.left=nc3;
        nc3.left=nc4;

        System.out.println(tree2str(nc1));    //  "1(2()(4))(3)"
    }
}
