import java.util.*;
/**
 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 *
 * Created by Mellon on 9/8/16.
 */
public class L159_LongestSubstringwithAtMostTwoDistinctCharacters {
    /*
    这道题其实就是经典的窗口移动题，感觉难度其实是Medium。题目的要求是对于输入的字符串，要求返回只包含两个字母的子串最长的长度。
    解法就是我们维护一个窗口的2个指针，一个指向窗口左端，一个指向窗口右端。然后右边的指针不断向右移动，如果窗口里的子串包含的字符种类数大于2种，
    则向右移动窗口的左指针，直到窗口重新恢复到包含字符种类数为2为止。时间复杂度是O(n)
    代码如下：
    */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0)
            return 0;

        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>(); // key: character, value: count of the character(key) in the moving window
        int start = 0;
        int len = 0;
        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c,1);
            }

            if(map.get(c)==1) count++;

            while(count>2) {

                char c2 = s.charAt(start);
                map.put(c2,map.get(c2)-1);

                if(map.get(c2)<=0)
                    count--;
                // 左指針往右
                start++;
            }
            len = Math.max(i-start+1,len);
        }
        return len;
    }

    public static void main(String[] args){
        String input = "eceba";
        System.out.print(lengthOfLongestSubstringTwoDistinct(input));
    }
}
