/**
 * Created by Mellon on 8/5/17.
 */
public class MaximumBinaryTree {
    /*
    Time complexity : O(n^2)
​​    The function construct is called n times. At each level of the recursive tree,
    we traverse over all the nn elements to find the maximum element.
    In the average case, there will be a log(n) levels leading to a complexity of O(nlog(n)).
    In the worst case, the depth of the recursive tree can grow upto n, which happens in the case of a sorted nums array,
    giving a complexity of O(n^2)

    Space complexity : O(n).
    The size of the set can grow upto n in the worst case.
    In the average case, the size will be log(n) for n elements in nums,
    giving an average case complexity of O(log(n))

    * */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;

        int idxMax = findMaxIndex(nums, start, end);

        TreeNode root = new TreeNode(nums[idxMax]);

        root.left = build(nums, start, idxMax - 1);
        root.right = build(nums, idxMax + 1, end);

        return root;
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
