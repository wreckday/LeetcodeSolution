/**
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 * Created by Mellon on 6/3/17.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s==null || s.length()==0) return s;
        int start = 0;
        int end = s.length()-1;
        char[] charArray = s.toCharArray();

        while(start<end){
            char temp;
            temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }
}
