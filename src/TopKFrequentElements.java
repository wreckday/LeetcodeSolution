import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * Created by Mellon on 5/4/16.
 */
public class TopKFrequentElements {
    /*
    build a priority queue takes O(NlogN)
    insert or delete takes O(logN)
    * */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.containsKey(num)? map.get(num) + 1 : 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq1 = new PriorityQueue<>((o1, o2)->o2.getValue()-o1.getValue());
        pq1.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(pq1.poll().getKey());
        }
        return res;
    }

    public static List<Integer> topKFrequentBucketSort(int[] nums, int k) {
        // bucket index is frequency, value are a integer array which are nums
        //List of integer array
        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.subList(0,k);
    }

    public static void main(String[] args){
        int[] nums = {1, 1, 1, 2, 2, 3,};
        int k = 2;
        List<Integer> res = topKFrequentBucketSort(nums, k);
        for(Integer i:res){
            System.out.print(i+",");
        }
    }
}
