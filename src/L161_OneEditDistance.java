/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * Created by Mellon on 9/5/16.
 */
public class L161_OneEditDistance {

    public static boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length()) > 1)
            return false;

        if(s.length() == t.length())
            return isOneModify(s,t);

        if(s.length() > t.length())
            return isOneDel(s,t);

        return isOneDel(t,s);
    }

    public static boolean isOneDel(String s,String t){
        for(int i=0,j=0;i<s.length() && j<t.length();i++,j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i+1).equals(t.substring(j));
            }
        }
        return true;
    }

    public static boolean isOneModify(String s,String t){
        int diff =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff==1;
    }

    public static void main(String[] args){
        String s = "abc";
        String t = "abde";
        System.out.println(isOneEditDistance(s, t));
    }
}
