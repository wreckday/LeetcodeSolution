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
    // when the number is shown up again which means that it goes loop cycle

    public boolean isHappy(int n) {
        List<Integer> map = new ArrayList<Integer>();
        if(n == 1)
            return true;

        while(!map.contains(n)) {
            map.add(n);
            int sum = 0;

            while(n!=0) {
                int last = n%10;
                sum += last*last;
                n = n / 10;
            }

            if(sum == 1)
                return true;
            else
                n = sum;
        }
        return false;
    }

    /*
    I see the majority of those posts use hashset to record values. Actually,
     we can simply adapt the Floyd Cycle detection algorithm.
     I believe that many people have seen this in the Linked List Cycle detection problem.

     Figured it out! If it is a happy number than it will stay at one and the slow pointer will eventually catch up.
     On the other hand, there must be a recurring number (that's why we need a hashset.)


     Nice idea, but it seems that if n is a happy number, definitely fast will turn to 1 first,
     which means in this case, your code will take one time more loops than it should be,
     because you have to wait the slow turning to 1 as well. So I made a little simplification.
    */
    public int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyFloydCycle(int n) {
        int slow, fast;
        slow = fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);

        if (slow == 1)
            return true;
        else
            return false;
    }
}
