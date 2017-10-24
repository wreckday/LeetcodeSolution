import java.util.HashMap;

/**
 * Created by Mellon on 5/12/17.
 */
public class L340_LongestSubstringwithAtMostKDistinctCharacters {
    /*
这道题其实就是经典的窗口移动题，感觉难度其实是Medium。题目的要求是对于输入的字符串，要求返回只包含两个字母的子串最长的长度。
解法就是我们维护一个窗口的2个指针，一个指向窗口左端，一个指向窗口右端。然后右边的指针不断向右移动，如果窗口里的子串包含的字符种类数大于2种，
则向右移动窗口的左指针，直到窗口重新恢复到包含字符种类数为2为止。时间复杂度是O(n)
代码如下：
*/
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0)
            return 0;

        int[] map = new int[128];
        int start = 0;
        int end = 0;
        int count = 0;
        int maxLen = 0;

        while (end < s.length()) {

            if (map[s.charAt(end)] == 0) {
                count++;
            }
            map[s.charAt(end)]++;


            while (count > k) { // invalid
                // 左指針往右移, 直到變成valid
                map[s.charAt(start)]--;

                if(map[s.charAt(start)]==0) {
                    count --;
                }
                start ++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args){
        String input = "aaaaaaaaabbbbbbaaaaabbhhhhhhaaabhabbahabaaaaa";
        System.out.println(lengthOfLongestSubstringKDistinct(input, 3));
    }
}
