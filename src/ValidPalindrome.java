/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.


 * Created by Mellon on 4/28/15.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        int l=0;
        int r=s.length()-1;

        while(l<r){
            if(!isValid(s.charAt(l))){
                l++;
                continue;
            }

            if(!isValid(s.charAt(r))){
                r--;
                continue;
            }

            if(!isSame(s.charAt(l),s.charAt(r))){
                return false;
            }

            l++;
            r--;

        }
        return true;
    }

    private boolean isValid(char c){
        if(c>='a'&&c<='z' || c>='A'&&c<='Z' || c-'0'>=0&&c-'0'<=9)
            return true;
        return false;
    }

    private boolean isSame(char c1, char c2){
        if(c1==c2 || c1-c2 == 'A'-'a' || c1-c2 == 'a'-'A' )
            return true;
        return false;
    }
}
