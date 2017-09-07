/**
 * Created by Mellon on 8/19/17.
 */
public class EqualTreePartition {
    public static class Result{
        boolean equalTree;
        int sumCurrent;
    }

    public static boolean checkEqualTree(TreeNode root) {
        sumTree(root);
        Result result = helper(root);
        return result.equalTree==true;
    }

    private static Result helper(TreeNode root){
        if(root==null){
            return new Result();
        }
        Result result = new Result();

        Result resultLeft = helper(root.left);
        Result resultRight = helper(root.right);

        if(resultLeft.equalTree || resultRight.equalTree) {
            result.equalTree=true;
            return result;
        }

        result.sumCurrent = resultLeft.sumCurrent + resultRight.sumCurrent + root.val;

        if(sum-resultRight.sumCurrent == resultRight.sumCurrent || sum-resultLeft.sumCurrent == resultLeft.sumCurrent) {
            result.equalTree = true;
        }
        return result;
    }

    static int sum = 0;
    public static void sumTree(TreeNode root) {
        if(root==null) return;
        sum+=root.val;
        sumTree(root.left);
        sumTree(root.right);
    }


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        System.out.println(checkEqualTree(n1));
    }
}
