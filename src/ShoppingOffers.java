import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mellon on 7/8/17.
 */
public class ShoppingOffers {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }

    public static int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int i) {
        // base case
        if (i == special.size())   // no special applied
            return dot(needs, price);

        ArrayList<Integer> clone = new ArrayList<>(needs);
        int j = 0;
        for (j = 0; j < special.get(i).size() - 1; j++) {
            int diff = clone.get(j) - special.get(i).get(j);
            if (diff < 0)
                break;
            clone.set(j, diff);
        }

        if (j == special.get(i).size() - 1)  // current special fits => min(specialCode price + rest items dfs , dfs)
            return Math.min(special.get(i).get(j) + shopping(price, special, clone, i), shopping(price, special, needs, i + 1));
        else // current special not fit, so go to next special code
            return shopping(price, special, needs, i + 1);
    }

    public static int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 5);

        List<Integer> specialItem1 = Arrays.asList(3, 0, 5);
        List<Integer> specialItem2 = Arrays.asList(1, 2, 10);
        List<List<Integer>> special = Arrays.asList(specialItem1, specialItem2);

        List<Integer> needs = Arrays.asList(3, 2);

        //System.out.println(shoppingOffers(price, special, needs));

        // test case 2
        List<Integer> price2 = Arrays.asList(2, 3, 4);

        List<Integer> special2Item1 = Arrays.asList(1, 1, 0, 4);
        List<Integer> special2Item2 = Arrays.asList(2, 2, 1, 9);
        List<List<Integer>> special2 = Arrays.asList(special2Item1, special2Item2);
        List<Integer> needs2 = Arrays.asList(1, 2, 1);

        //System.out.println(shoppingOffers(price2, special2, needs2));


        // test case 3
        List<Integer> price3 = Arrays.asList(9, 9);
        List<Integer> special3Item1 = Arrays.asList(1, 1, 1);
        List<List<Integer>> special3 = Arrays.asList(special3Item1);
        List<Integer> needs3 = Arrays.asList(2, 2);

        //  System.out.println(shoppingOffers(price3, special3, needs3));

        // test case 4
        List<Integer> price4 = Arrays.asList(2, 3);
        List<Integer> special4Item1 = Arrays.asList(1, 0, 1);
        List<Integer> special4Item2 = Arrays.asList(0, 1, 2);
        List<List<Integer>> special4 = Arrays.asList(special4Item1, special4Item2);
        List<Integer> needs4 = Arrays.asList(1, 1);

        System.out.println(shoppingOffers(price4, special4, needs4));
    }
}
