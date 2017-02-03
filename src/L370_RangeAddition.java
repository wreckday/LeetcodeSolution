/**
 Assume you have an array of length n initialized with all 0's and are given k update operations.

 Each operation is represented as a triplet: [startIndex, endIndex, inc]
 which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive)
 with inc.

 Return the modified array after all k operations were executed.

 Example:

 Given:

 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]
 Explanation:

 Initial state:
 [ 0, 0, 0, 0, 0 ]

 After applying operation [1, 3, 2]:
 [ 0, 2, 2, 2, 0 ]

 After applying operation [2, 4, 3]:
 [ 0, 2, 5, 5, 3 ]

 After applying operation [0, 2, -2]:
 [-2, 0, 3, 5, 3 ]
 *
 * Created by Mellon on 7/31/16.
 */
public class L370_RangeAddition {
    // time complexity
    public static int[] getModifiedArray2(int length, int[][] updates) {
        int[] a = new int[length];
        for(int i=0;i<updates.length;i++){
            int startIndex = updates[i][0];
            int endIndex = updates[i][1];
            int increment = updates[i][2];
            for(int j=startIndex;j<=endIndex;j++){
                a[j] = a[j] + increment;
            }
        }
        return a;
    }

    // Java O(K + N)time complexity Solution
    public static int[] getModifiedArray(int length, int[][] updates) {

        int[] res = new int[length];
        for(int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];

            res[start] += value;

            if(end < length - 1)
                res[end + 1] -= value;

        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
/*
Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
* */
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
       Common.printIntegerArray(getModifiedArray(5, updates));

     }
}
