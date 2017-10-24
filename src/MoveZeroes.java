/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * Created by Mellon on 4/2/16.
 */
public class MoveZeroes {
    // Shift non-zero values as far forward as possible
// Fill remaining space with zeros

    // 第一種方法寫入次數較多, 把非0的移到前面, 最後再全部填補0
    public void moveZeroesBetterSolustion(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0)
                nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // Facebook follow up 寫入較少, 不需要照原本的順序, 適用于0比較少或者0在比較前面的位置, 因為0 只要出現, 後面的元素都要跟著往前移動, 這樣大部分的元素都因此而動了
    // 所以我們可以有一個指針一開始先指向最尾端, 此end 指針的後面都是0, 當slow的指針遇到0時, 就和end指針swap, end--, swap完
    // 之後的start指針不需要往右, 因為end 指針之前指向的元素也有可能是0, 所以交換過後還是要再次檢查slow指針
    public static void moveZeroes(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] == 0) {
                swap(nums, start, end);
                end--;
            } else {
                start++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 0, 3, 1, 0};
        moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}

