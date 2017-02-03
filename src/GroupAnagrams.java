import java.util.*;

/**
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.
 *
 * Created by Mellon on 8/23/16.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length==0) return res;

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] s_chars = s.toCharArray();
            Arrays.sort(s_chars);
            String sorted_s = new String(s_chars);
            if(map.containsKey(sorted_s)){
                map.get(sorted_s).add(s);
            }else{
                List<String> newKey = new ArrayList<>();
                newKey.add(s);
                map.put(sorted_s, newKey);
            }
        }
        // sort inner element
        for(List<String> list: map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> res = groupAnagrams(strs);
        Common.printNestedStringList(res);
    }
}
