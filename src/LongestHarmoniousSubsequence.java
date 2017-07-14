import java.util.*;

/**
 * Created by Mellon on 5/20/17.
 */
public class LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            if(map.containsKey(e)){
                map.put(e, map.get(e)+1);
            }else {
                map.put(e, 1);
            }
        }
        int[] items = new int[2];
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currentKey = entry.getKey();
            int currentValue = entry.getValue();
            if(map.containsKey(currentKey + 1)){
                if((map.get(currentKey+1)+currentValue)>=max){
                    max = map.get(currentKey+1)+currentValue;
                    items[0] = currentKey;
                    items[1] = currentKey+1;
                }
            }
            if(map.containsKey(currentKey-1)){
                if((map.get(currentKey-1)+currentValue)>=max){
                    max = map.get(currentKey-1)+currentValue;
                    items[0] = currentKey;
                    items[1] = currentKey-1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums1 = {1,3,2,2,5,2,3,7};
        int[] nums = {1, 4, 2, 3};
        System.out.println(findLHS(nums));
    }
}
