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
