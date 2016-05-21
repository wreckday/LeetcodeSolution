import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 5/2/16.
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();
        helper(digits, new StringBuilder(), 0, result, table);
        return result;
    }

    private static void helper(String digits, StringBuilder sb, int level, List<String> result, String[] table){
        // base case
        if(level==digits.length()){
            if(sb.toString().length()>0)
                result.add(sb.toString());
            return;
        }

        int table_index = digits.charAt(level)-'0';
        for(int i=0; i<table[table_index].length();i++){
            sb.append(table[table_index].charAt(i));
            helper(digits, sb, level + 1, result, table);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args){
        List<String> result = letterCombinations("23");
        for(String s : result){
            System.out.println(s + ",");
        }
    }
}
