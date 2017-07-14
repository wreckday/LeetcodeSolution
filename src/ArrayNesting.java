import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mellon on 5/27/17.
 */
public class ArrayNesting {
    public static int arrayNesting(int[] nums) {
        int max = 0;
        int[] map = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int val = helper(nums, nums[i], map);

            max = Math.max(max, val);
        }
        return max;
    }

    private static int helper(int[] nums, int start, int[] map){
        int i=start;
        int count = 0 ;
        Set<Integer> set = new HashSet<>();
        while (!set.contains(i)){
            if(map[i]!=0){
                count = count + map[i];
                return count;
            }
            set.add(i);
            count++;
            map[i] = set.size();
            i = nums[i];

        }
        return count;
    }

    public static void main(String[] args){
        int[] input = {5,4,0,3,1,6,2};
        int[] input2 = {0, 2, 1};
        System.out.println(arrayNesting(input));
    }
}
