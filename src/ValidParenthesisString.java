/**
 * Created by Mellon on 9/16/17.
 */
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        if(s == null || s.length()==0) return true;
        return helper(s, 0, 0, 0);
    }

    private static boolean helper(String s, int left, int right, int index){
        if(index==s.length()){
            if(left == right) return true;
            return false;
        }
        if(right > left) return false;
        boolean val = false;
        boolean val2 = false;
        boolean val3 = false;

        if(s.charAt(index) == '('){
             val = helper(s, left+1, right, index+1);
        }else if(s.charAt(index) == ')'){
             val2 = helper(s, left, right+1, index+1);
        }else { // *
             val3 =  helper(s, left+1, right, index+1) ||
            helper(s, left, right+1, index+1) || helper(s, left, right, index+1);
        }

        return val || val2 || val3;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
    }
}
