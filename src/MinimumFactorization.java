import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 6/18/17.
 */
public class MinimumFactorization {
    /*
    For a given n, following are the two cases to be considered.
Case 1: n < 10 When n is smaller than n, the output is always n+10.
    For example for n = 7, output is 17. For n = 9, output is 19.

Case 2: n >= 10 Find all factors of n which are between 2 and 9 (both inclusive).
    The idea is to start searching from 9 so that the number of digits in result are minimized.
    For example 9 is preferred over 33 and 8 is preferred over 24.
    Store all found factors in an array. The array would contain digits in non-increasing order,
    so finally print the array in reverse order.

Following is the implementation of above concept.
    * */
    public int smallestFactorization(int n) {
        // Case 1: If number is smaller than 10
        if (n < 10) return n;

        // Case 2: Start with 9 and try every possible digit
        List<Integer> res = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            // If current digit divides n, then store all
            // occurrences of current digit in res
            while (n % i == 0) {
                n = n / i;
                res.add(i);
            }
        }

        // If n could not be broken in form of digits
        if (n != 1) return 0;

        // Get the result from the array in reverse order
        long result = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            result = result * 10 + res.get(i);
            if (result > Integer.MAX_VALUE) return 0;
        }

        return result <= Integer.MAX_VALUE ? (int)result : 0;
    }
}
