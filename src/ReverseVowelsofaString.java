import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mellon on 4/23/16.
 *
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsofaString {
    public static String reverseVowels(String s) {
        if(s==null || s.length()==0) return s;
        int start = 0;
        int end = s.length()-1;
        char[] charArray = s.toCharArray();
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        while(start<end){
            char temp;
            if(vowels.contains(s.charAt(start)) && vowels.contains(s.charAt(end))){
                temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }else if(vowels.contains(charArray[start])){
                end--;
            }else if(vowels.contains(charArray[end])){
                start++;
            }else{
                start++;
                end--;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args){
        String input = "Hello";
        System.out.print(reverseVowels(input));
    }
}
