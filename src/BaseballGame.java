import java.util.Stack;

import static java.lang.Character.isDigit;

/**
 * Created by Mellon on 9/23/17.
 */
public class BaseballGame {
    public static int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(String i : ops){
            if(i.equals("C")){
                // not count as round
                // make the last valid round point removed from sum
                if(!stack.isEmpty()) stack.pop();
            }else if(i.equals("D")){
                // Double the last valid round point and add to sum
                int score = 0;
                if(!stack.isEmpty()) {
                    score = 2*stack.peek();
                    stack.push(score);
                }
            } else if(i.equals("+")) {
                // + add the last two valid round's point to sum
                int score = 0;
                if(stack.size()>=2){
                    score = stack.get(stack.size()-1) + stack.get(stack.size()-2);
                }else if(stack.size()==1) {
                    score = stack.peek();
                }
                stack.push(score);
            } else {
                int score = Integer.parseInt(i);
                stack.push(score);
            }
        }

        while(!stack.isEmpty()){
            sum = sum + stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        //String[] ops = {"5","-2","4","C","D","9","+","+"};
        String[] ops1 = {"5","2","C","D","+"};
        //System.out.println(calPoints(ops));
        System.out.println(calPoints(ops1));
    }
}
