import java.util.Stack;

/**
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.


 *
 * Created by Mellon on 10/14/16.
 */
public class BasicCalculator2 {

    public static void main(String[] args){
        String input = "4+2*3";
        int res = calculate(input);
        System.out.print(res);
    }

    public static int calculate(String s) {
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
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break; // only non-negative int, impossible '2*-1'
                    case '/': stack.push(stack.pop() / num); break;
                }
                num = 0;
                last_op = c;
                result += stack.peek();
            }
        }
        return result;
    }
}
