import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Mellon on 10/22/17.
 */
public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args){
//        int[] nums = {10, 5, 2, 6};
//        System.out.println(numSubarrayProductLessThanK(nums, 100));
        //long numLong = 12345678912345l;
        //long numLong = 9223372036854775807l;
        //double maxmiumDouble = Double.MAX_VALUE;
        //System.out.println(9923372036854775808d);
//        Random random = new Random();
//        int dealtIndex = 0;
//        List<Integer> cards = Arrays.asList(1, 2, 3, 4, 5);
//        for (int i = cards.size() - 1; i >= dealtIndex; i--) {
//            //int index = random.nextInt((i - dealtIndex) + 1) + dealtIndex;
//            int index = random.nextInt((i) + 1);
//            int temp = cards.get(index);
//        }
    }
}
