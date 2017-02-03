/**
 *
 Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?

 * Created by Mellon on 6/25/16.
 */
public class L186_ReverseWordsinaStringII {
    public static void reverseWords(char[] s) {
        if(s == null || s.length==0) return;
        reverse(s, 0, s.length-1);
        int j=0;
        for(int i=0;i<s.length;i++){
            if(i==s.length-1 || s[i+1]==' '){
                reverse(s, j, i);
                j=i+2;
            }

        }
    }

    private static void reverse(char[] s, int start, int end){
        while(start<end){
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        String str = "the sky is blue";
        char[] chars = str.toCharArray();
        reverseWords(chars);


        System.out.println(String.valueOf(chars));
    }
}
