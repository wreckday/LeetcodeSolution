import java.util.Stack;

/**
 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ),
 the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * Created by Mellon on 7/25/15.
 */
public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> sign = new Stack<Integer>();
        sign.push(1);
        int lastOp = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '+':
                    lastOp = 1;
                    break;
                case '-':
                    lastOp = -1;
                    break;
                case '(':
                    sign.push(lastOp*sign.peek());
                    lastOp=1;
                    break;
                case ')':
                    sign.pop();
                    break;
                default:
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))){
                        num = num * 10 + s.charAt(i++) - '0';
                    }

                    i--;
                    res += lastOp * num * sign.peek();
            }
        }
        return res;
    }

    public static void main(String[] args){
        String input = "(4+(2-3))";
        int res = calculate(input);
        System.out.print(res);
    }
}
