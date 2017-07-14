/**
 Given a string s and a list of strings dict,
 you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict.
 If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag.
 Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

 Example 1:
 Input:
 s = "abcxyz123"
 dict = ["abc","123"]
 Output:
 "<b>abc</b>xyz<b>123</b>"

 Example 2:
 Input:
 s = "aaabbcc"
 dict = ["aaa","aab","bc"]
 Output:
 "<b>aaabbc</b>c"
 Note:
 The given dict won't contain duplicates, and its length won't exceed 100.
 All the strings in input have length in range [1, 1000].
 *
 * Created by Mellon on 6/11/17.
 */
public class AddBoldTaginString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String d: dict) {
            for (int i = 0; i <= s.length() - d.length(); i++) {
                if (s.substring(i, i + d.length()).equals(d)) {
                    for (int j = i; j < i + d.length(); j++)
                        bold[j] = true;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (bold[i]) {
                res.append("<b>");
                while (i < s.length() && bold[i])
                    res.append(s.charAt(i++));
                res.append("</b>");
            } else
                res.append(s.charAt(i++));
        }
        return res.toString();
    }

    /*
    Complexity Analysis
Time complexity : O(l*s*x)
Space complexity : O(s)
    * */
}
