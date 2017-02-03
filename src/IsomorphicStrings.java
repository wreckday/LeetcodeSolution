import java.util.*;
/**
 *
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 * Created by Mellon on 10/4/16.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphicMy(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if(s==null && t==null) return true;
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }else{
                //"ab", "aa"
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args){
        String s1 = "apple";
        String s2 = "taauq";
       // System.out.println(isIsomorphic(s1, s2));
        System.out.println(isIsomorphic(s1, s2));
    }
}
