import java.util.Arrays;

/**
 Given a string which contains only lowercase letters,
 remove duplicate letters so that every letter appear once and only once.
 You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"
 *
 * Created by Mellon on 3/27/17.
 */
public class RemoveDuplicateLetters {
    // "cbacdcbc"
    public static String removeDuplicateLetters(String s) {
        if( s.length()<2 )
            return s;
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();

        while( s.length()>0 ){
            for( int i=0; i<s.length(); i++ )
                count[ s.charAt(i)-'a' ]++;

            int pos=0;
            for( int i=0; i<s.length(); i++ ){
                if( s.charAt(i) < s.charAt(pos) )  //always choose the left lexically smallest char
                    pos = i;

                //if a char will not appear in the following sequence, stop here, otherwise the chars of the result may not be in correct order,
                //e.g. "eeffga", 'a' will be selected first;  we must maintain the relative order of chars in the result according to the input
                if( --count[s.charAt(i)-'a'] == 0 )
                    break;
            }

            result.append( s.charAt(pos) );
            s = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
            Arrays.fill(count, 0);
        }

        return result.toString();
    }

    public String removeDuplicateLettersRecursion(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLettersRecursion(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static void main(String[] args){
        String input = "cbacdcbc";
        System.out.println(removeDuplicateLetters(input));
    }
}
