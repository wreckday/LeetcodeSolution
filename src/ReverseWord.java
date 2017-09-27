/**
 * Created by Hsiang-Ting Yang on 5/30/15.
 */
public class ReverseWord {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length()==0) return sb.toString();

        //Removing Anything Apart from a-zA-Z0-9 using the Regular Expressions
//        String reg = "[^a-zA-Z0-9]+";
//        if (s.matches(reg)) return sb.toString();

        //Removing the end spaces using the trim and split("\\s+") to remove bunch of consistent white spaces.
        String [] str = s.trim().split("\\s+");
        for(int i =str.length-1 ; i>=0 ; i--){
            sb.append(str[i]);
            sb.append(" ");
        }
        //To remove the last the " " provided to the function
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        //System.out.println(reverseWords(input));
        String[] res = "a      b".split("\\s+");

        int v = 5;
    }
}
