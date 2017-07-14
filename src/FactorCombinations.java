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

    public static List<List<Integer>> getFactorsFaster(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helperFaster(n, 2, new ArrayList<>(), result);
        return result;
    }

    public static void helperFaster(int n, int start, List<Integer> item, List<List<Integer>> result){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<>(item));
            }
            return;
        }

        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helperFaster(n / i, i, item, result);
                item.remove(item.size()-1);
            }
        }

        // e.g. n = 6    (6/2 ->  start = i = 3, n = 3)
        int i = n;
        item.add(i);
        helperFaster(n / i, i, item, result);
        item.remove(item.size()-1);
    }

    public static void main(String[] args){
        int input = 37;
        List<List<Integer>> res2 = getFactorsFaster(input);
        Common.printNestedList(res2);
    }
}
