import java.util.Arrays;

/**
 Write a function to find the longest common prefix string amongst an array of strings.
 * Created by Mellon on 8/18/16.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Argument checks
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for (int i = 0, j = 0; i < first.length && j < last.length; i++, j++) {
            if (first[i] != last[j]) break;
            sb.append(first[i]);
        }
        return sb.toString();
    }
}
