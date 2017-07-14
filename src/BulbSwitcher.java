import java.util.Arrays;

/**
 * Created by Mellon on 4/4/16.
 */
public class BulbSwitcher {
    public static int bulbSwitch2(int n) {
        if (n == 1 || n == 2) return 1;
        boolean[] bulbs = new boolean[n];
        Arrays.fill(bulbs, true);
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j = j + i + 1) {
                if (bulbs[j])
                    bulbs[j] = false;
                else
                    bulbs[j] = true;
            }
        }
        int count = 0;

        for (boolean b : bulbs) {
            if (b)
                count++;
        }
        return count;
    }

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

/*
    A bulb ends up on iff it is switched an odd number of times.
Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i.
So bulb i ends up on if and only if it has an odd number of divisors.
Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6.
So bulb i ends up on if and only if i is a square.

So just count the square numbers.

Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n].
And 1 is the smallest root. So you have the roots from 1 to R, that's R roots.
Which correspond to the R squares. So int(sqrt(n)) is the answer.
(C++ does the conversion to int automatically, because of the specified return type).
* */

    public static void main(String[] args) {
        int num = 4;
        System.out.println(bulbSwitch(num));
        System.out.print(bulbSwitch2(num));
    }
    /*
    [1, 0, 0, 1, 1]
    *
    *
    * */
}
