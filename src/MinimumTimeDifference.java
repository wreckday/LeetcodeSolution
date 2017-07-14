import java.util.Arrays;
import java.util.List;

/**
 *

 Given a list of 24-hour clock time points in "Hour:Minutes" format,
 find the minimum minutes difference between any two time points in the list.

 Example 1:
 Input: ["23:59","00:00"]
 Output: 1
 Note:
 The number of time points in the given list is at least 2 and won't exceed 20000.
 The input time is legal and ranges from 00:00 to 23:59.

 * Created by Mellon on 3/11/17.
 */
public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        final int n = timePoints.size();
        int[] minutes = new int[n*2];
        int index = 0;
        for (String point : timePoints) {
            int num = toMinutes(point);
            minutes[index++] = num;
            minutes[index++] = num + 24*60;
        }

        Arrays.sort(minutes);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n*2; i++) {
            int d = minutes[i] - minutes[i-1];
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    private static int toMinutes(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }

    public static void main(String[] args){
        List<String> timepoints = Arrays.asList("02:06","04:05");

        findMinDifference(timepoints);
    }
}
