import java.util.*;

/**
 * Created by Mellon on 10/14/17.
 */
public class DegreeofanArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= maxValue) {
                maxValue = entry.getValue();
            }
        }

        List<Integer> items = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                items.add(entry.getKey());
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i : items){
            min = Math.min(min, getDistance(i, nums));
        }

        return min;
    }

    private static int getDistance(int maxKey, int[] nums){
        int start = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxKey){
                start = i;
                break;
            }
        }

        int end = 0;
        for(int i= nums.length-1;i>=0;i--){
            if(nums[i]==maxKey){
                end = i;
                break;
            }
        }

        return end-start+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }
}
