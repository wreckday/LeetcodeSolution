/**
 *
 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 * Created by Mellon on 7/6/16.
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < s.length(); i++)
            res = res * 26 + (s.charAt(i) - 'A'+ 1);
        return res;
    }

    public static void main(String[] args){
        String input = "AB";
        System.out.print(titleToNumber(input));
    }
}
