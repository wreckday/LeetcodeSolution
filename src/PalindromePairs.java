import java.util.*;
import java.util.List;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * <p>
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 * <p>
 * <p>
 * Created by Mellon on 4/21/17.
 */
public class PalindromePairs {
    // HashMap
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                addPair(map, res, str1, str2, i, false);
                if(str2.length() != 0) {   // words1 = {"bb","b"};
                    addPair(map, res, str2, str1, i, true);
                }
            }
        }
        return res;
    }

    private static void addPair(Map<String, Integer> map, List<List<Integer>> res,
                                String str1, String str2, int index, boolean reverse) {
        if (isPalindrome(str1)) {
            String str2rev = new StringBuilder(str2).reverse().toString();
            if (map.containsKey(str2rev) && map.get(str2rev) != index) {
                List<Integer> list = new ArrayList<>();
                if(!reverse) {
                    list.add(map.get(str2rev));
                    list.add(index);
                } else {
                    list.add(index);
                    list.add(map.get(str2rev));
                }
                res.add(list);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args){
//        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        String[] words1 = {"bb","b"};
//        List<List<Integer>> res = palindromePairs(words);
        List<List<Integer>> res1 = palindromePairs(words1);
        Common.printNestedList(res1);
    }
}
