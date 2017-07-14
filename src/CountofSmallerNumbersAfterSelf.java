import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 You are given an integer array nums and you have to return a new counts array.
 The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 Example:
 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.


 Return the array [2, 1, 1, 0].
 *
 *
 * Created by Mellon on 3/26/17.
 */
public class CountofSmallerNumbersAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        TreeNodeCount root = null;
        Integer[] res = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }

    private static TreeNodeCount insert(int num, TreeNodeCount root, Integer[] res, int index, int preSum) {
        if(root == null) {
            // create new node no matter if it is duplicated
            res[index] = preSum;
            root = new TreeNodeCount(num);
        } else if(num >= root.val) {
            // only change the preSum when going right,
            // 1) preSum is the count before root.parent
            // 2) root.segmentLeftCount is the count between root.parent and root
            // 3) num > root.val ? 1 : 0 is the count of root itself,
            // if the statement of question is "smaller or equals to", it will be always 1
            root.right = insert(num, root.right, res, index, preSum + root.segmentLeftCount + (num > root.val ? 1 : 0));
        } else {
            // only change segmentLeftCount when going left
            // at this time, root.parent <= num < root, so increase root.segmentLeftCount
            root.segmentLeftCount++;
            root.left = insert(num, root.left, res, index, preSum);
        }
        return root;
    }

    public static void main(String[] args){
        int[] nums = {5, 2, 6, 1};
        List<Integer> res = countSmaller(nums);
        Common.printIntegerList(res);
    }

    /*
This BST is a kind of augmented BST,
please check this video to learn more about it(Princeton Algorithm: https://www.youtube.com/watch?v=8Samxh_gV-Q).
    * */
}

class TreeNodeCount {
    public int val, segmentLeftCount = 0;
    TreeNodeCount left = null, right = null;

    public TreeNodeCount(int val) {
        this.val = val;
    }

    public String toString() {
        return val + "(" + segmentLeftCount + ")";
    }
}
