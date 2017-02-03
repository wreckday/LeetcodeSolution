import java.util.ArrayList;
import java.util.List;

/**
 Numbers can be regarded as product of its factors. For example,
 8 = 2 x 2 x 2; = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.
 Note:
 Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].

 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.

 Examples:
 input: 1      output: []
 input: 37    output:  []
 input: 12    output:  [  [2, 6],  [2, 2, 3],  [3, 4]]
 input: 32    output:  [  [2, 16],  [2, 2, 8],  [2, 2, 2, 4],  [2, 2, 2, 2, 2],  [2, 4, 4],  [4, 8]]

 *
 * Created by Mellon on 8/18/15.
 */
public class FactorCombinations {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }

    public static List<List<Integer>> productFactors(int input){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(input, 2, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int value, int start, List<Integer> item, List<List<Integer>> res ){
        if (value <= 1) {
            if (item.size() > 1) {
                res.add(new ArrayList<>(item));
            }
            return;
        }

        for(int i=start;i<=value;i++){
            if(value%i==0){
                item.add(i);
                helper(value / i, i, item, res);
                item.remove(item.size()-1);
            }
        }

    }

    public static void main(String[] args){
        int input = 8;
        List<List<Integer>> res = productFactors(input);
        List<List<Integer>> res2 = getFactors(input);
        int v =5;

    }
}
