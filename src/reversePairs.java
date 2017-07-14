import java.util.Arrays;

/**
 * Created by Mellon on 2/11/17.
 */
public class reversePairs {
    public static int reversePairsSlow(int[] nums) {
        int count=0;
        long lower_limit_j = Long.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
            long nums_j = (long)nums[j];
            if(nums_j>=lower_limit_j) count++;
            for(int i=0;i<j;i++){
                long nums_i = (long)nums[i];

                if(nums_i>nums_j*2) {
                    count++;
                    Math.max(lower_limit_j, nums_j);
                }
            }
        }
        return count;
    }

    public static int reversePairs(int[] nums) {
        int count=0;
        for(int j=0;j<nums.length;j++){
            int i=0;
            int copy_j = j;
            int[] copy = nums.clone();
            Arrays.sort(copy, i, j);
            long nums_j = (long)copy[j];
            while(i<j){
                int mid = i+(j-i)/2;
                long nums_m = (long)copy[mid];
                if(nums_m>nums_j*2) {
                    count = count + j-mid;
                    j = mid;
                }else if(nums_m<=nums_j*2){
                    i = mid +1;
                }
            }
            j=copy_j;
        }
        return count;
    }


    public static void main(String[] args){
        int[] nums = {2, 4, 3, 5, 1};
        int[] nums2 = {5, 1, 3, 7, 1};
        int[] nums3 = {5, 4, 3, 2, 1};
        System.out.println(reversePairsSlow(nums3));
        System.out.println(reversePairs(nums3));
    }
}
