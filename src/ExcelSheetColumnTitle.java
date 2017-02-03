/**
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 *
 * Created by Mellon on 7/7/16.
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle1(int n) {
        if(n==0)
            return null;

        StringBuilder sb = new StringBuilder();

        n=n-1;

        while(n>=0) {
            sb.append((char) (n%26+'A'));
            n = n/26;
            n=n-1;
        }

        return sb.reverse().toString();
    }

    public static String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            char ch = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            res = ch + res;
        }
        return res;
    }

    public static void main(String[] args){
        //System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(52));
    }
}
