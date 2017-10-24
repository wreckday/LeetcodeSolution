/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * <p>
 * Created by Mellon on 10/12/17.
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        int[] map = new int[256];
        int start = 0;
        int end = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // build table base on T
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }


        while (end < s.length()) {
            // If char in s exists in t, decrease counter
            if (map[s.charAt(end)] > 0) {
                count--;
            }
            // Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative.
            map[s.charAt(end)]--;

            while (count == 0) { // When we found a valid window, move start to find smaller window.
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                map[s.charAt(start)]++;  // 左指針往右移動 縮小窗口
                if (map[s.charAt(start)] > 0) {  // 遇到t裡面的字了
                    count++;
                }
                start++;
            }
            end++;
        }
        return minLen != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLen) : "";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
    }
}
