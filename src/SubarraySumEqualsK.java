import java.util.*;
/**
 * Created by Mellon on 4/29/17.
 */
public class SubarraySumEqualsK {
    public static int subarraySumSlow(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum==k) {
                    count++;

                }
            }
            sum=0;
        }
        return count;
    }

    // L325 MaximumSizeSubarraySumEqualsk
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum == k) {
                count++;
            } else if(map.containsKey(sum-k)){
                count++;
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long cur = 0;
        int answer = 0;
        map.put(cur, 1);
        for (int num : nums) {
            cur += num;
            answer += map.getOrDefault(cur - k, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return answer;
    }

    public int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        int[] cum = new int[n+1];
        for(int i = 0;i < n;i++){
            cum[i+1] = cum[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for(int i = 0;i <= n;i++){
            Integer res = map.get(cum[i]-k);
            if(res != null)ret += res;
            if(map.containsKey(cum[i])){
                map.put(cum[i], map.get(cum[i]) + 1);
            }else{
                map.put(cum[i], 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        int[] nums2 = {3, 2, 5, -5, 10};
        int[] nums3 = {0,0,0,0,0,0,0,0,0,0};
        System.out.println(subarraySum(nums2, 5));
        System.out.println(subarraySum(nums2, 5));
        System.out.println(subarraySum(nums3, 0));
    }
}
