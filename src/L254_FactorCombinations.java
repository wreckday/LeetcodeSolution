import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,

 8 = 2 col 2 col 2;
 = 2 col 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:
 Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.

 Examples:
    input: 1
    output: []

    input: 37
    output:[]

    input: 12
    output:
    [
        [2, 6],
        [2, 2, 3],
        [3, 4]
    ]

    input: 32
    output:
    [
        [2, 16],
        [2, 2, 8],
        [2, 2, 2, 4],
        [2, 2, 2, 2, 2],
        [2, 4, 4],
        [4, 8]
    ]

 * Created by Mellon on 5/28/16.
 */
public class L254_FactorCombinations {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n==1) return res;
        helper(n, new ArrayList<>(), res, 2, n);
        return res;
    }

    private static void helper(int n, List<Integer> item, List<List<Integer>> res, int start, int N){
        // base case
        if(n==1){
            res.add(new ArrayList<>(item));
            return;
        }

        for(int i=start;i<=n&&i<N;i++){

            if(n%i==0){
                item.add(i);
                helper(n/i, item, res, i, N);
                item.remove(item.size()-1);
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> res = getFactors(2);
        Common.printNestedList(res);
    }
}
