import java.util.Collections;
import java.util.PriorityQueue;

/**
 Median is the middle value in an ordered integer list.
 If the size of the list is even, there is no middle value.
 So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.

 For example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2

 *
 * Created by Mellon on 2/1/17.
 */
public class FindMedianfromDataStream {
}

class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    private boolean even = true;     // same size in both queue

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}