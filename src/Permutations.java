import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * Created by Mellon on 4/24/16.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper(int[] nums, List<Integer> item, List<List<Integer>> res){
        // base case
        if(item.size()==nums.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(isValidFill(item, nums[i])){
                helper(nums, item, res);
                item.remove(item.size()-1);
            }
        }
    }

    private static boolean isValidFill(List<Integer> item, int element){
        if(!item.contains(element)){
            item.add(element);
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int[] input = {1, 2, 3};
        List<List<Integer>> res = permute(input);
        for(List<Integer> list : res){
            StringBuilder sb = new StringBuilder();
            for(Integer i: list){
                sb.append(i);
                sb.append(",");
            }
            System.out.println(sb.toString());
        }
    }
}
