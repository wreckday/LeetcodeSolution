/**
 * Created by Mellon on 2/19/15.
 */
public class RemoveDuplicates {
    /*
    快慢指針, i 是慢指針, j 是快指針, 當nums[i] == nums[j] 時, 代表i 到j 的值是重複的, 當nums[i] 不等於nums[j]時, 就略過了重複的區段,
    然後再把快指針的值nums[j] 附於 nums[i+1]。 最後要回傳新的長度所以慢指針要加1
    */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args){
        int[] A = {1, 1, 1, 3, 3, 4, 5};
        System.out.println(removeDuplicates(A));
    }
}
