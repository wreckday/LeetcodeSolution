import java.util.*;
/**
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection
 between a letter in pattern and a non-empty substring in str.

 Examples:
 pattern = "abab", str = "redblueredblue" should return true.
 pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false.
 Notes:
 You may assume both pattern and str contains only lowercase letters.

 * Created by Mellon on 1/30/17.
 */
public class L291_WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(str, 0, pattern, 0, map, set);
    }

    boolean isMatch(String str, int startFromIndexOfStr, String pat, int indexOfPattern, Map<Character, String> map, Set<String> set) {
        // base case
        if (startFromIndexOfStr == str.length() && indexOfPattern == pat.length()) return true;
        if (startFromIndexOfStr == str.length() || indexOfPattern == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(indexOfPattern);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, startFromIndexOfStr)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, startFromIndexOfStr + s.length(), pat, indexOfPattern + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = startFromIndexOfStr; k < str.length(); k++) {
            String p = str.substring(startFromIndexOfStr, k + 1);

            if (set.contains(p))
                continue;

            // create or update it
            map.put(c, p);
            set.add(p);

            // continue to match the rest
            if (isMatch(str, k + 1, pat, indexOfPattern + 1, map, set)) {
                return true;
            }

            // backtracking
            map.remove(c);
            set.remove(p);
        }
        // we've tried our best but still no luck
        return false;
    }
}
