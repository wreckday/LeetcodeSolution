/**
 * Created by Mellon on 4/9/17.
 */
public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        char[] chars = s.toCharArray();
        int start=0;
        int end = 0;
        while(end<s.length()){
            if(chars[start]==' '&&chars[end]==' '){
                start++;
                end++;
            } else if(chars[start] != ' '&&chars[end]!=' '){
                end++;
                if(end+1==s.length()){
                    reverseHelper(chars, start, end);
                    end ++;
                }
            } else if(chars[start] != ' ' && chars[end] == ' '){
                reverseHelper(chars, start, end-1);
                end++;
                start = end;
            }
        }
        return new String(chars);
    }

    private static void reverseHelper(char[] chars, int start, int end){
        while(start<end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
        String s2 = "   Let's take LeetCode contest";
        String s3 = "Let's  take LeetCode contest";
        String s4 = "Let's  take LeetCode contest ";
        String s5 = "";
        String s6 = "     ";
        String s7 = "a";
        String res = reverseWords(s7);
        System.out.println(res);
    }
}
