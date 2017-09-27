/**
 Given a string, you need to reverse the order of characters in each word within a sentence
 while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string

 *
 * Created by Mellon on 4/9/17.
 */
public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i=0;
        for(int j=0; j<c.length; j++){
            if(c[j]==' '){
                reverse(c, i, j-1);
                i=j+1;
            }
        }

        reverse(c, i, c.length-1);
        return new String(c);
    }

    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
//        String s2 = "   Let's take LeetCode contest";
//        String s3 = "Let's  take LeetCode contest";
//        String s4 = "Let's  take LeetCode contest ";
//        String s5 = "";
//        String s6 = "     ";
//        String s7 = "a";
        String res = reverseWords(s);
        System.out.println(res);
    }
}
