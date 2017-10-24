import java.util.*;

/**
 * Created by Mellon on 2/8/15.
 */
public class Subsets {
    /*
    ＃＃＃思路：題目說求出全部解, 直覺就會想到用backtracking
    ＃＃＃時間複雜度：2 的 n 次方
    ＃＃＃空間複雜度：recursive call and result set
    ＃＃＃相關題： permutation, phone
    ＃＃＃哪些條件提示我想到了解法： all possible solution
    */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int[] nums, int start, List<Integer> subset, List<List<Integer>> res){
        res.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++){
            subset.add(nums[i]);
            helper(nums, i+1, subset, res);
            subset.remove(subset.size()-1);   // 這邊一定要清除之前加過的state到原本的
        }
    }


    public static void main(String[] args){
        int[] a = {1,2,3};
        printArrayListList(subsets(a));
        System.out.println();
    }

    private static void printArrayListList(List<List<Integer>> res){
        for(List<Integer> list : res){
            System.out.print("[");
            for(Integer i:list){
                System.out.print(i+",");
            }
            System.out.print("]");
        }
    }


}
