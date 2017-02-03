import java.util.*;

/**
 Given a pattern and a string str, find if str follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * Created by Mellon on 1/29/17.
 */
public class WordPattern {
    //I go through the pattern letters and words in parallel and compare the indexes where they last appeared.

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> index = new HashMap();
        for (Integer i=0; i<words.length; ++i){
            Integer a = (Integer) index.put(pattern.charAt(i), i);
            Integer b = (Integer) index.put(words[i], i);
            if(!Objects.equals(a, b)) return false;
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }

    public boolean wordPattern3(String pattern, String str) {
        String[] arr= str.split(" ");
        Set<String> set = new HashSet<>();
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(!set.add(arr[i]))
                    return false;
                map.put(c, arr[i]);
                set.add(arr[i]);
            }
        }
        return true;
    }


    public static void main(String[] args){
//        String p1 = "abbc";
//        String s1 = "dog cat dog cat";
//        System.out.print(wordPattern(p1, s1));



        int digit = 127;
        Integer a = digit;
        Integer b = digit;
        boolean result = a==b;
        System.out.print("test: " + result);
    }
}
