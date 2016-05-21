/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.
 *
 * Created by Mellon on 5/13/16.
 */
public class L276_PaintFence {
    /*
    There can be multiple 2 adjacent posts have same colors--a more clear way to put it is "no 3 adjacent posts have the same color"

for 4 post 2 color case (0 for black, 1 for red)
0011 is a valid solution,
0001 is not
    * */
    public int numWays(int n, int k) {

        //O(n) time java solution, O(1) space
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }


    /*

    We divided it into two cases.

the last two posts have the same color, the number of ways to paint in this case is sameColorCounts.

the last two posts have different colors, and the number of ways in this case is diffColorCounts.

The reason why we have these two cases is that we can easily compute both of them, and that is all I do.
When adding a new post, we can use the same color as the last one (if allowed) or different color.
If we use different color, there're k-1 options, and the outcomes shoule belong to the diffColorCounts category.
If we use same color, there's only one option,
 and we can only do this when the last two have different colors (which is the diffColorCounts).
There we have our induction step.

     */
}
