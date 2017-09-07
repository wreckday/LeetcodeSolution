/**
 Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string],
 where the encoded_string inside the square brackets is being repeated exactly k times.
 Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid;
 No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits
 and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 *
 * Created by Mellon on 8/11/17.
 */
public class DecodeString {
    static int i=0;
    public static String decodeString(String s) {
        return dfs(s);
    }

    private static String dfs(String s){
        String str = "";
        while(i<s.length()&&s.charAt(i) != ']'){
            if(!Character.isDigit(s.charAt(i))){
                str+=s.charAt(i);
                i++;
            }else {
                int digit = 0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))) {
                    digit = 10 * digit + s.charAt(i)-'0';
                    i++;
                }
                i++; //'['
                String t = dfs(s);
                i++; // ']'
                while (digit>0){
                    str += t;
                    digit--;
                }
            }

        }
        return str;
    }


    public static void main(String[] args){
        String s = "3[a]2[bc]";
        System.out.print(decodeString(s));

    }
}
