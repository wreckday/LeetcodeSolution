/**
 * Created by Mellon on 6/3/17.
 */
public class CanPlaceFlowers {
/*
The solution is very simple. We can find out the extra maximum number of flowers, count,
that can be planted for the given flowerbed arrangement.
To do so, we can traverse over all the elements of the flowerbed and find out those elements which are 0
(implying an empty position).For every such element, we check if its both adjacent positions are also empty.
If so, we can plant a flower at the current position without violating the no-adjacent-flowers-rule.
For the first and last elements, we need not check the previous and the next adjacent positions respectively.

If the count obtained is greater than or equal to n, the required number of flowers to be planted,
we can plant nn flowers in the empty spaces, otherwise not.

Complexity Analysis

Time complexity : O(n). A single scan of the flowerbed array of size nn is done.

Space complexity : O(1). Constant extra space is used.

* */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    public static void main(String[] args){
        int[] flowerbed = {1,0,0,0, 0, 0, 1};
        int[] flowerbed2 = {1, 0, 0, 0, 1, 0, 0};
        int[] flowerbed3 = {1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 2));
        //System.out.println(canPlaceFlowers2(flowerbed, 2));
    }
}
