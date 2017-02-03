/**
 Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 *
 * Created by Mellon on 10/5/16.
 */
public class ShortestPalindrome {
    /*
        KMP-based O(n) time & O(n) memory solution
        We can construct the following string and run KMP algorithm on it:
        (s) + (some symbol not present in s) + (reversed string)

        After running KMP on that string as result we get a vector p with values of a prefix function for each character
         (for definition of a prefix function see KMP algorithm description).
         We are only interested in the last value because it shows us the largest suffix of the reversed string
         that matches the prefix of the original string.
         So basically all we left to do is to add the first k characters of the reversed string to the original string,
         where k is a difference between original string size and the prefix function
         for the last character of a constructed string.
    */
    public String shortestPalindrome(String s) {
        if(s.length() <= 1){ return s; }
        String curs = s + " " + new StringBuilder(s).reverse().toString();
        int[] trace = new int[curs.length()];
        for(int i = 1 ; i < curs.length() ; i++){
            int curindex = trace[i-1];
            while(curindex > 0 && curs.charAt(curindex) != curs.charAt(i)){
                curindex = trace[curindex-1];
            }
            if(curs.charAt(curindex) == curs.charAt(i)){
                trace[i] = curindex+1;
            }
        }
        return new StringBuilder(s.substring(trace[curs.length()-1])).reverse().toString() + s;
    }
}
