import java.util.*;
/**
 * Created by Mellon on 9/20/17.
 */
public class PathSumIV {
    static int sum = 0;
    static Map<Integer, Integer> tree = new HashMap<>();

    public static int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // build a map as a tree structure, the first digit in the key is depth, the second digit in the key is position
        // map's value is node's value
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }

        traverse(nums[0] / 10, 0);

        return sum;
    }

    private static void traverse(int root, int preSum) {
        // root here is key in the map
        int level = root / 10;
        int pos = root % 10;
        // according to key in the map , we can compute left subtree and right subtree
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;

        int curSum = preSum + tree.get(root);

        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }

        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }

    /*
    題目要求求出root 到 葉子的path sum 總和, 給我們三個digits的數字, 代表 深度, 位置, 值。
    我們要怎麼知道是不是到葉子了呢？如果一個點沒有左子樹和沒有右子樹 就是葉子。 這時候 我們可以用hashMap 去建造一棵樹
    hashMap 的 key 的第一個數是深度, 第二個數是位置, 有了key 我們就可以算出此點的左子樹和右子樹, 如果都不存在hashMap裡,
    那我們就要加到總和裡, 否則繼續邊遞迴下去找葉子求總和。
    * */


    public static void main(String[] args) {
        int[] nums = {111, 212, 224, 323, 335};
        int[] nums2 = {113, 215, 221};
        int[] nums3 = {113, 221};
        int[] nums4 = {113};
        int[] nums5 = {115,215,224,325,336,446,458};
        int[] nums6 = {115,215,224,325,336,446,458, 571};
        System.out.println(pathSum(nums));
        System.out.println(pathSum(nums2));
        System.out.println(pathSum(nums3));
        System.out.println(pathSum(nums4));
        System.out.println(pathSum(nums5));
        System.out.println(pathSum(nums6));
    }
}
