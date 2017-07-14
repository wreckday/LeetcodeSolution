import java.util.LinkedList;
import java.util.Queue;

/**
 Given a stream of integers and a window size,
 calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3

 *
 * Created by Mellon on 6/15/17.
 */

// space complexity : queue space, O(size)
// time complexity : O(1) next
public class MovingAveragefromDataStream {
    private double previousSum = 0.0;
    private int maxSize;
    private Queue<Integer> currentWindow;

    public MovingAveragefromDataStream(int size) {
        currentWindow = new LinkedList<>();
        maxSize = size;
    }

    public double next(int val) {
        if (currentWindow.size() == maxSize) {
            previousSum -= currentWindow.remove();
        }

        previousSum += val;
        currentWindow.add(val);
        return previousSum / currentWindow.size();
    }
}
