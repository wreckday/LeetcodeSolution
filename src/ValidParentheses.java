import java.util.Stack;

/**
 * Created by Mellon on 4/28/15.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s==null||s.length()==0)
            return false;
        Stack<Character> stack = new Stack<Character>();

        int i = 0;

        while(i<s.length()){
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
            }

            i++;
        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(isValid("()"));

    }
}
