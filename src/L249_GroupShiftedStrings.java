import java.util.*;

/**
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Return:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 Note: For the return value, each inner list's elements must follow the lexicographic order.
 *
 * Created by Mellon on 5/24/16.
 */
public class L249_GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strings){
            String key = getBitMap(s);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        for(String key: map.keySet()){
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }

    private static String getBitMap(String s){
        int[] arr = new int[s.length()];
        arr[0] = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)-s.charAt(0) < 0)
                arr[i] = (s.charAt(i)-s.charAt(0))+26; // treat "az" as the same group as "ba"
            else
                arr[i] = s.charAt(i)-s.charAt(0);
        }
        return Arrays.toString(arr);
    }
    public static void main(String[] args){
        String[] strings2 = {"az", "ba"};
        //String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> res = groupStrings(strings2);
//        List<List<String>> res2 = groupStrings(strings2);
//        Common.printNestedStringList(res);
//        System.out.println("");
//        Common.printNestedStringList(res2);
    }
}
