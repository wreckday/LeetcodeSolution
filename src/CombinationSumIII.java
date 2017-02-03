import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]

 * Created by Mellon on 5/10/16.
 */
public class CombinationSumIII {
    // backtracking
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int start, int k, int n, List<Integer> item, List<List<Integer>> res){

        // base case
        if(item.size() > k) return;

        if(item.size()==k && n==0){
            res.add(new ArrayList<>(item));
            return;
        }

        for(int i=start;i<=9;i++){
            if(n-i<0) continue;

            item.add(i);
            helper(i+1, k, n-i, item, res);
            item.remove(item.size()-1);
        }
    }
}
