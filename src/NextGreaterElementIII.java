import java.util.ArrayList;
import java.util.*;

/**
 Given a positive 32-bit integer n,
 you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n.
 If no such positive 32-bit integer exists, you need to return -1.

 Example 1:
 Input: 12
 Output: 21
 Example 2:
 Input: 21
 Output: -1
 *
 * Created by Mellon on 4/9/17.
 */
public class NextGreaterElementIII {
    /*
    private static int min = Integer.MAX_VALUE;
    private static int copy;
    public static int nextGreaterElement(int n) {
        copy = n;
        List<Integer> candidates = new ArrayList<>();

        while(n>0){
            candidates.add(n%10);
            n=n/10;
        }
        boolean[] visited = new boolean[candidates.size()];
        List<Integer> res = new ArrayList<>();
        res.add(0);
        helper(candidates, visited, res);
        return min!=Integer.MAX_VALUE?min:-1;
    }

    private static void helper(List<Integer> candidates, boolean[] visited, List<Integer> res){
        // base case
        if(res.get(0)> copy){
            min = Math.min(min, res.get(0));
            return;
        }
        // backTracking
        for(int i=0;i<candidates.size();i++){
            if(!visited[i]){
                visited[i]=true;
                int temp = res.get(0);
                int sum = res.get(0)*10+candidates.get(i);
                res.set(0, sum);
                helper(candidates, visited, res);
                res.set(0, temp);
                visited[i]=false;
            }
        }
    }

*/
    public static int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();

        for (int i=chs.length-2; i>=0; i--) {
            if (chs[i] < chs[i+1]) {
                for (int j=chs.length-1; j>i; j--) {
                    if (chs[j] > chs[i]) {
                        swap(chs, i, j);
                        reverse(chs, i+1, chs.length-1);
                        return toInt(chs);
                    }
                }
            }
        }
        return -1;
    }
    private static void reverse(char[] chs, int p, int r) {
        for (; p < r; p++, r--) {
            swap(chs, p, r);
        }
    }
    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
    private static int toInt(char[] chs) {
        int val = 0;

        for (int i=0; i<chs.length; i++) {
            int digit = chs[i]-'0';
            if (val > (Integer.MAX_VALUE-digit)/10) {
                return -1;
            } else {
                val = 10*val+digit;
            }
        }
        return val;
    }

    public static void main(String[] args){
        int input = 2147483647;
        int res = nextGreaterElement(input);
        System.out.println(res);
    }
}
