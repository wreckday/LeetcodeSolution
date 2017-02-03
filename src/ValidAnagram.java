import java.util.Arrays;
import java.util.HashMap;

/**
 Given two strings s and t, write a function to determine if t is an anagram of s.
 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 Note:
 You may assume the string contains only lowercase alphabets.
 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 * Created by Mellon on 10/19/16.
 */
public class ValidAnagram {
    /**
     *      HashTable
     This idea uses a hash table to record the times of appearances of each letter in the two strings s and t.
     For each letter in s, it increases the counter by 1 while for each letter in t,
     it decreases the counter by 1. Finally, all the counters will be 0 if they two are anagrams of each other.
     */

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        for (int count : counts)
            if (count!=0) return false;
        return true;
    }

    /*
    Sorting
    For two anagrams, once they are sorted in a fixed order, they will become the same.
    */
    public static boolean isAnagramSorting(String s, String t) {
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;

        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        for(int i=0;i<s.length();i++){
            if(s_array[i] != t_array[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramSorting(s, t));
    }
}
