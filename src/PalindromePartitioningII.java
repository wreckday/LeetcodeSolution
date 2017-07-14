/**
 * Created by Mellon on 2/12/17.
 */
public class PalindromePartitioningII {
    /*
    This can be solved by two points:

    cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
    If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
    The 2nd point reminds us of using dp (caching).

    a   b   a   |   c  c
                    j  i
           j-1  |  [j, i] is palindrome
       cut(j-1) +  1
    */

    public static int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (i-j<2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public static int minCutDic(String s){
        if(s == null || s.length() == 0) return 0;
        boolean[][] dict = getDict(s);
        int[] res = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <=i; j++) {
                if (dict[j][i]) {
                    min = j ==0 ? 0 : Math.min(min, res[j-1]+1);
                }
            }
            res[i] = min;
        }
        return res[s.length()-1];
    }

    private static boolean[][] getDict(String s){
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i) == s.charAt(j) && (i-j<2 || dict[j+1][i-1]))
                    dict[j][i] = true;
            }
        }
        return dict;
    }

    public static void main(String[] args){
        String s = "aab";
        System.out.println(minCut(s));
        System.out.println(minCutDic(s));
    }
}
