import java.util.*;
/**
 Given a picture consisting of black and white pixels, and a positive integer N,
 find the number of black pixels located at some specific row R and column C that align with all the following rules:

 Row R and column C both contain exactly N black pixels.
 For all rows that have a black pixel at column C, they should be exactly the same as row R
 The picture is represented by a 2D char array consisting of 'B' and 'W',
 which means black and white pixels respectively.

 Example:
 Input:
 [['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'W', 'B', 'W', 'B', 'W']]

 N = 3
 Output: 6
 Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
 0    1    2    3    4    5         column index
 0    [['W', 'B', 'W', 'B', 'B', 'W'],
 1     ['W', 'B', 'W', 'B', 'B', 'W'],
 2     ['W', 'B', 'W', 'B', 'B', 'W'],
 3     ['W', 'W', 'B', 'W', 'B', 'W']]
 row index

 Take 'B' at row R = 0 and column C = 1 as an example:
 Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
 Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.

 Note:
 The range of width and height of the input 2D array is [1,200].
 *
 * Created by Mellon on 3/5/17.
 */
public class Lonely_Pixel_II {
    /*
    The difficult parts are validating the two rules:

Row R and column C both contain exactly N black pixels.
For all rows that have a black pixel at column C, they should be exactly the same as row R
My solution:

Scan each row. If that row has N black pixels, put a string signature,
which is concatenation of each characters in that row,
as key and how many times we see that signature into a HashMap.
For input:
[['W', 'B', 'W', 'B', 'B', 'W'],
['W', 'B', 'W', 'B', 'B', 'W'],
['W', 'B', 'W', 'B', 'B', 'W'],
['W', 'W', 'B', 'W', 'B', 'B']]
We will get a HashMap:
{"WBWBBW": 3, "WWBWBB": 1}
Go through the HashMap and if the count of one signature is N,
those rows potentially contain black pixels we are looking for. Then we validate each of those columns.
For each column of them has N black pixels, we get N valid black pixels.
For above example, only the first signature "WBWBBW" has count == 3.
We validate 3 column 1, 3, 4 where char == 'B', and column 1 and 3 have 3 'B', then answer is 2 * 3 = 6.
Time complexity analysis:

For part 1 above, it is obvious. It's O(m * n) m = number of rows, n = number of cols.
For part 2, it is a little bit tricky. Consider the worst case,
there will be m / N signatures in the HashMap and all of them has count == N,
meaning we need to do scanCol for each signature. Because each signature has N black pixels,
so totally we need to do scanCol m / N * N = m times. So runtime for part 2 is O(m * n) again.
Combine part 1 and 2, overall runtime is O(2 * m * n) = O(m * n).

    * */
    public static int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        if (m == 0) return 0;
        int n = picture[0].length;
        if (n == 0) return 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String key = scanRow(picture, i, N);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < n; j++) {
                    if (key.charAt(j) == 'B' && scanCol(picture, j) == N) {
                        result += N;
                    }
                }
            }
        }

        return result;
    }

    private static String scanRow(char[][] picture, int row, int target) {
        int n = picture[0].length;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                count++;
            }
            sb.append(picture[row][j]);
        }

        if (count == target) return sb.toString();
        return "";
    }

    private static int scanCol(char[][] picture, int col) {
        int m = picture.length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (picture[i][col] == 'B') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        // ["WBWBBW","BWBWWB","WBWBBW","BWBWWB","WWWBBW","BWBWWB"]
        char[][] matrix = {
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'B', 'W', 'B', 'W', 'W', 'B'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'B', 'W', 'B', 'W', 'W', 'B'},
                {'W', 'W', 'W', 'B', 'B', 'W'},
                {'B', 'W', 'B', 'W', 'W', 'B'}
        };
        System.out.println(findBlackPixel(matrix, 3));
    }
}
