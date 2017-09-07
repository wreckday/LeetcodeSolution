import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Mellon on 7/22/17.
 */
public class MaximumLengthofPairChain {
    public static int findLongestChain(int[][] pairs) {
        // sort
        Arrays.sort(pairs, (a, b) -> (a[1]-b[1]));
        int max = 1;
        int index = 0;
        for(int i = 1;i<pairs.length;i++){
            if(pairs[index][1]<pairs[i][0]){
                max++;
                index = i;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[][] inputs = {
                {1, 2},
                {3, 100},
                {4, 5},
                {6, 7}
        };

        int[][] inputs2 = {
                {6, 7},
                {7, 100},
                {1, 2},
                {4, 6},
                {101, 1000}
        };
        System.out.println(findLongestChain(inputs));
    }
}
