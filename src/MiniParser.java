/**
 Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:

 String is non-empty.
 String does not contain white spaces.
 String contains only digits 0-9, [, - ,, ].
 Example 1:

 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.
 Example 2:

 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.
 *
 * Created by Mellon on 8/18/16.
 */
/*
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s == null || s.isEmpty()) return new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        int sign = 1, len = s.length() ;
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c == '['){
                stack.push(new NestedInteger()); // start of a new NestedInteger
            }else if( c == ']' && stack.size() > 1){ // End of a NesterdInteger
                NestedInteger n = stack.pop();
                stack.peek().add(n);
            }else if(c == '-'){ // just change the sign
                sign = -1;
            }else if(Character.isDigit(c)){ // if digit check for all the continous ones
                int num = c - '0';
                while( i + 1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                num = num * sign;
                if(!stack.isEmpty()){
                    stack.peek().add(new NestedInteger(num)); // add to previous item if not empty
                }else{
                    stack.push(new NestedInteger(num));
                }
                sign = 1; // reset the sign
            }
        }
        return stack.isEmpty() ? new NestedInteger() : stack.pop() ;
    }
}
*/
