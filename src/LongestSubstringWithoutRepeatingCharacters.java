import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mellon on 6/1/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // time: (n)
    /*
        不重复的子串,最常见的方法就是从i开始遍历子串,如果碰到重复的下次从i+1开始, 重复的 判断,显然是靠哈希表了. (这里可以假设是256个字符,然后用数组山寨一个哈希表)
这个做法虽然也对,但是里面包含了大量的重复劳动, 比如abcdefge, 我们从a开始,第二个 碰到e的时候,发现了重复,我们从b再开始就没有意义了(肯定是再次在第二个e遇到重复), 争取的做法是在第一个e之后的下一个(也就是f)开始再次的遍历.
为了做到能够记录上一次出现e的位置,我们的山寨哈希表可以稍作修改,-1表示没有出现过, 正值表示上次出现的位置
    */
    public int lengthOfLongestSubstring_hashmap(String s) {
        if(s==null||s.length()==0) return 0;
        int[] arr = new int[256];
        Arrays.fill(arr, -1);

        int len=0;
        int max=0;

        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)]!=-1){ // 遇到重複的字了, 要重新從這個重複的字上一次出現過的位置重新走
                max = Math.max(len, max);
                len=0;
                i = arr[s.charAt(i)]+1;
                Arrays.fill(arr, -1);
            }
            arr[s.charAt(i)] = i;
            len++;
        }
        return Math.max(max, len);
    }

    /*
這一題跟Longest Substring with At Most Two Distinct Characters 類似, 而且可以套用同一種模板！
首先, 解題思路是維持一個窗口和兩個指針還有count, 當count>0 時, 就代表出現重複的字了, 所以我們要
把左指針向右移動直到字串又變成合法為止。當count==0時, 代表目前字串合法, 所以我們可以繼續往右移動右指針
時間複雜度O(n);
空間複雜度O(1);
*/
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int[] map = new int[128];
        int start = 0;
        int end = 0;
        int count = 0;
        int maxLen = 0;

        while (end < s.length()) {

            if (map[s.charAt(end)] > 0) {
                count++;
            }
            map[s.charAt(end)]++;


            while (count > 0) { // invalid
                // 左指針往右移, 直到變成valid
                map[s.charAt(start)]--;

                if(map[s.charAt(start)]==1) {
                    count --;
                }
                start ++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
