import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * <p>
 * <p>
 * <p>
 * Created by Mellon on 10/14/16.
 */
public class BasicCalculator2 {

    public static void main(String[] args) {
        String input = "4+2*3";
        int res = calculate(input);
        System.out.print(res);
    }

    public static int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int last_op = '+';
        for (int i = 0; i < s.length(); i++) {   // op is last operator
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {    // must be 'if' or i=len-1 won't reach here
                if ("*/".indexOf(last_op) >= 0)                          // subtract top before mul/div
                    result -= stack.peek();
                switch (last_op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break; // only non-negative int, impossible '2*-1'
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                last_op = c;
                result += stack.peek();
            }
        }
        return result;
    }

    public static int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }
}
