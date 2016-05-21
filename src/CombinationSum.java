import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mellon on 3/1/15.
 */
/*
    Given a set of candidate numbers (C) and a target number (T),
    find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.

    Note:
        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        The solution set must not contain duplicate combinations.
        For example, given candidate set 2,3,6,7 and target 7,
        A solution set is:
        [7]
        [2, 2, 3]
*/


public class CombinationSum {
    /*
      这个题是一个NP问题，方法仍然是N-Queens中介绍的套路。
      基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，
      并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。
      算法复杂度因为是NP问题，所以自然是指数量级的。代码如下：
    */
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0||target<0)
            return res;
        // sort first
        Arrays.sort(candidates);
        helper1(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper1(int[] candidates, int start, int target, List<Integer> item, List<List<Integer>> res){

        // base case: target=0, added to res
        if(target==0){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        if(target<0)
            return;

        for(int i=start;i<candidates.length;i++){

            //为了避免出现重复的结果集，我们只对于第一次得到这个数进行递归，接下来就跳过这个元素了，
            //因为接下来的情况会在上一层的递归函数被考虑到
            /*
                Input:	[1,1], 1
                Output:	[[1],[1]]
                Expected:	[[1]]
            */
            if(i>start&&candidates[i]==candidates[i-1])
                continue;

            item.add(candidates[i]);

            //point: i doesn't need to be incremented here.
            //The question's description mentions that
            //"The same repeated number may be chosen from C unlimited number of times."
            helper1(candidates, i, target - candidates[i], item, res);
            item.remove(item.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(0, candidates, target, new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> res){
        // base case
        if(target==0){
            res.add(new ArrayList<>(current));
        }


        for(int i=index;i<candidates.length;i++){

            int value = candidates[i];
            current.add(value);

            if(target<0){
                helper(i+1, candidates, target-value, current, res);
            }else{
                helper(i, candidates, target-value, current, res);
            }

            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args){
        int[] input = {48,22,49,24,26,47,33,40,37,39,31,46,36,43,45,34,28,20,29,25,41,32,23};

        Common.printNestedList(combinationSum1(input, 69));
    }
}
