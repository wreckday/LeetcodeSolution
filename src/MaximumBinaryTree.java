/**
 * Created by Mellon on 8/5/17.
 */
public class MaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int index = findMaxIndex(nums, 0, nums.length-1);
        TreeNode root = new TreeNode(nums[index]);
        helper(nums, root, 0, nums.length-1, index );
        return root;
    }

    private static void helper(int[] nums, TreeNode root, int start, int end, int index){
        if(start >= end) return;

        if(start<index){
            int currentLeftIndex = findMaxIndex(nums, start, index-1);
            TreeNode left = new TreeNode(nums[currentLeftIndex]);
            root.left = left;
            helper(nums, left, start, index-1, currentLeftIndex);
        }

        if(index<end){
            int currentRightIndex = findMaxIndex(nums, index+1, end);
            TreeNode right = new TreeNode(nums[currentRightIndex]);
            root.right = right;
            helper(nums, right, index+1, end, currentRightIndex);
        }
    }

    private static int findMaxIndex(int[] nums, int start, int end){
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    //****************
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    public TreeNode maxTree(int[] nums, int l, int r) {
        if (l > r)
            return null;
        if (l == r)
            return new TreeNode(nums[l]);
        int max = Integer.MIN_VALUE;
        int index = l - 1, i;

        for (i=l;i<=r;i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = maxTree(nums, l, index - 1);
        root.right = maxTree(nums, index+1, r);
        return root;
    }


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        n3.left = n5;
        n4.right = n6;

        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);
        int v= 5;

    }
}
