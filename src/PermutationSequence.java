import java.util.ArrayList;
import java.util.List;

/**
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.


 *
 * Created by Mellon on 8/24/16.
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        helper(n, k, new StringBuilder(), res, new boolean[n+1]);
        return res.get(res.size()-1);
    }

    private static void helper(int n, int k, StringBuilder sb, List<String> res, boolean[] used){
        // base case
        if(sb.length() == n){
            res.add(sb.toString());
        }
        if(res.size()==k){
            return;
        }

        for(int i=1;i<=n;i++){
            if(!used[i]){
                used[i] = true;
                helper(n, k, sb.append(i), res, used);
                used[i] = false;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    public static void main(String[] args){
        int n = 3;
        int k = 6;
        System.out.print(getPermutation(n, k));

    }
}
