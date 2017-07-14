import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by Mellon on 2/18/17.
 */
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        int max = 0;
        int sum = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                sum = -1;
            }else{
                sum = 1;
            }

            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==0){
                    sum = sum-1;
                }else{
                    sum = sum+1;
                }
                if(sum == 0){
                    max = Math.max(max, j+1-i);
                }
            }
        }
        return max;
    }

    public static int findMaxLength2(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum[i + 1] = sum[i] - 1;
            } else {
                sum[i + 1] = sum[i] + 1;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], new ArrayList<>());
            }
            map.get(sum[i]).add(i);
        }
        int answer = 0;

        for (List<Integer> list : map.values()) {
            answer = Math.max(answer, list.get(list.size() - 1) - list.get(0));
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(findMaxLength2(arr));
    }
}
