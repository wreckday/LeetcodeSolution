import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 4/24/16.
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].


 */
public class Permutationsii {
    public static List<List<Integer>> permuteUnique(int[] nums) {
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
            if(isValidFill(res, item, nums[i])){
                helper(nums, item, res);
                item.remove(item.size()-1);
            }
        }
    }

    private static boolean isValidFill(List<List<Integer>> res, List<Integer> item, int element){
        List<Integer> temp = new ArrayList<>(item);
        temp.add(element);

        for(List<Integer> list : res){
            boolean isSame = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i)==temp.get(i))
                    isSame = true;
            }
            if(isSame){
                // not valid
                return false;
            }
        }
        // Valid
        item.add(element);
        return true;
    }

    public static void main(String[] args){
        int[] input = {1, 2, 3};
        List<List<Integer>> res = permuteUnique(input);
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
