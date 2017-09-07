import java.util.Arrays;
import java.util.Comparator;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * Created by Mellon on 6/9/16.
 */
public class RussianDollEnvelopes {
    // time : n * n
    public static int maxEnvelopesNSquare(int[][] envelopes) {
        if (envelopes== null || envelopes.length==0 || envelopes[0]== null || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, (a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] table = new int[envelopes.length];
        int globalMax = 1;
        for(int i=0;i<envelopes.length;i++){
            int local = 1;
            for(int j=0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                    local = Math.max(local, table[j]+1);
                }

            }
            table[i]=local;
            globalMax = Math.max(local, globalMax);
        }
        return globalMax;
    }

    /*   NlogN
    1. Sort the array. Ascend on width and descend on height if width are same.
    2. Find the longest increasing subsequence based on height.
    Since the width is increasing, we only need to consider height.
    [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting
    otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
    * */
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length==0 || envelopes[0]== null || envelopes[0].length==0) return 0;
        Arrays.sort(envelopes, (a, b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));

        int[] dp = new int[envelopes.length+1];
        dp[0] = 0;
        int count = 0;
        for(int i=0;i<envelopes.length;i++){
            int index = Arrays.binarySearch(dp, 0, count+1, envelopes[i][1]);
            if(index<0){
                dp[-index-1] = envelopes[i][1];
                if(-index-1>count){
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args){
        int[][] input = {{4,5}, {4,6}, {6,7}, {2,3}, {1,1}};
        System.out.println(maxEnvelopes(input));
    }
}
