
/**
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91.
 (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 Hint:

 A direct way is to use the backtracking approach.
 Backtracking should contains three states which are (the current number, number of steps to get that number
 and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
 This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
 *
 * Created by Mellon on 6/14/16.
 */
public class CountNumberswithUniqueDigits {
   // The running time for this program is O(10!) worst case, or O(n!) if n < 10.
    public static int sum;
    public static int countNumbersWithUniqueDigits(int n) {
        if(n<0) return -1;
        long max = (long) Math.pow(10, n);
        sum = 1; // x == 0
        boolean[] used = new boolean[10];

        for (int i = 1; i < 10; i++) {
            used[i] = true;
            helper(i, max, used);
            used[i] = false;
        }

        return sum;

    }

    private static void helper(long prev, long max, boolean[] used){
        if (prev < max) {
            sum += 1;
        } else {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                long cur = 10 * prev + i;
                helper(cur, max, used);
                used[i] = false;
            }
        }
    }

// dp solution
/*

Following the hint. Let f(n) = count of number with unique digits of length n.

f(1) = 10. (0, 1, 2, 3, ...., 9)

f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.

f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij, we can pick k to form a 3 digit number ijk and there are 8 numbers that are different from i and j for k to choose from.

Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....

...

f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1

f(11) = 0 = f(12) = f(13)....

any number with length > 10 couldn't be unique digits number.

The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + .. + f(n)


*/
    public static int countNumbersWithUniqueDigits_DP(int n) {
        if (n == 0)
            return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;

        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.print(countNumbersWithUniqueDigits(2));
    }
}
