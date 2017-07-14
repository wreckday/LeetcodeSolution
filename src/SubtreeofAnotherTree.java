/**
 * Created by Mellon on 5/10/17.
 */
public class SubtreeofAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t==null ) return true;

        if(isSameTree(s, t)) return true;

        if(s!=null){
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }else
            return t==null;
    }



    private static boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;

        //1）左边为空而右边不为空；（2）左边不为空而右边为空；
        if(s==null || t==null) return false;

        //3）左边值不等于右边值
        if(s.val!=t.val)
            return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;

        System.out.println(isSubtree(n1, t1));
    }
}
