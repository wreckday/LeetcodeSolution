/**
 * Created by Mellon on 9/24/15.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums){
        int xor=0; int i=0;
        for(i=0;i<nums.length;i++){
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 3, 4};
        int ans = missingNumber(nums);
        System.out.print(ans);

    }
}
