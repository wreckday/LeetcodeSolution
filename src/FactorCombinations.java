import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 8/18/15.
 */
public class FactorCombinations {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
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
        helper(input, 2, new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper(int value, int start, List<Integer> item, List<List<Integer>> res ){
        if (value <= 1) {
            if (item.size() > 1) {
                res.add(new ArrayList<Integer>(item));
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
