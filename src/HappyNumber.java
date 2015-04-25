import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class HappyNumber {
    // idea: how to know what situation the integer is not happy?
    // when the number is shown up agian which means that it goes loop cycle

    public boolean isHappy(int n) {
        List<Integer> map = new ArrayList<Integer>();
        if(n == 1)
            return true;

        while(!map.contains(n))
        {
            map.add(n);
            int sum = 0;

            while(n!=0)
            {
                int last = n%10;
                sum += last*last;
                n = n / 10;
            }

            if(sum == 1)
                return true;
            else{
                n = sum;
            }
        }
        return false;
    }
}
