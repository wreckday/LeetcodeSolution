import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 Hint:

 Consider the palindromes of odd vs even length. What difference do you notice?
 Count the frequency of each character.
 If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 *
 * Created by Mellon on 5/13/16.
 */
public class L266_PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.get(c)==null){
                map.put(c, 1);
            }else
                map.put(c, map.get(c)+1);
        }

        int oddNum = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()%2!=0)
                oddNum++;

        }
        if(oddNum>1)
            return false;
        return true;
    }

    public static void main(String[] args){
        String s = "abcba";
        System.out.println(canPermutePalindrome(s));
    }
}
