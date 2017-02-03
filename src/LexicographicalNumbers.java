import java.util.ArrayList;
import java.util.List;

/**
 Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

 Subscribe to see which companies asked this question
 *
 * Created by Mellon on 8/27/16.
 */
public class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    /*
 * ans[i] = ans[i-1]*10 <= n ? ans[i-1]*10 : ans[i-1]%10 < 9 ? ans[i-1] + 1 : ans[i-1]/10%10 < 9 ? ...
 */
    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>(n);
        ans.add(1);
        int prev = 1;
        for (int i = 1; i < n; ++i) {
            if (prev * 10 <= n) {
                prev *= 10;
            } else {
                while (prev % 10 == 9 || prev == n)
                    prev /= 10;
                prev++;
            }
            ans.add(prev);
        }
        return ans;
    }

    public static void main(String[] args){
        lexicalOrder2(199);
        lexicalOrder2(3);
    }

}
