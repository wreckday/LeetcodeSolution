/**
 * Created by Mellon on 9/16/17.
 */
public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        if(s == null || s.length()==0) return false;
        int start = 0;
        int end = s.length()-1;
        int modified = 0;
        while(start<end){

            if(s.charAt(start) != s.charAt(end)) {
                if(modified == 1) {
                    modified ++;
                    break;
                }else {
                    start++;
                    modified ++;
                }

            } else {
                start++;
                end--;
            }

        }
        if(start >= end && modified<=1)
            return true;

        start = 0;
        end = s.length()-1;
        modified = 0;
        while(start<end){

            if(s.charAt(start) != s.charAt(end)) {
                if(modified == 1) {
                    modified ++;
                    break;
                }else {
                    end--;
                    modified ++;
                }

            } else {
                start++;
                end--;
            }

        }
        if(start >= end && modified<=1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "abbal";
        System.out.println(validPalindrome(s));
    }
}
