/**
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 *
 * Created by Mellon on 8/27/16.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int c = 0;
        while(i>=0||j>=0||c>0){

            if(i>=0){
                c = c+a.charAt(i)-'0';
                i--;
            }

            if(j>=0){
                c = c+b.charAt(j)-'0';
                j--;
            }
            sb.append(c%2);
            c = c/2;

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        String a = "111";
        String b = "111";
        System.out.println(addBinary(a, b));
    }
}
