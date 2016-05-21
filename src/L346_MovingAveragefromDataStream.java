import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 *
 * Created by Mellon on 5/13/16.
 */
public class L346_MovingAveragefromDataStream {
    //Java O(1) time solution.

//    static class MovingAverage {
//        private int [] window;
//        private int n, insert;
//        private long sum;
//
//        /** Initialize your data structure here. */
//        public MovingAverage(int size) {
//            window = new int[size];
//            insert = 0;
//            sum = 0;
//        }
//
//        public double next(int val) {
//            if (n < window.length)  n++;
//            sum -= window[insert];
//            sum += val;
//            window[insert] = val;
//            insert = (insert + 1) % window.length;
//
//            return (double)sum / n;
//        }
//    }

    static class MovingAverage {
        /** Initialize your data structure here. */
        Queue<Integer> queue = new LinkedList();
        double sum = 0;
        int size;

        MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if(queue.size()==size){

                int headValue = queue.remove();
                sum = sum - headValue;
            }
            queue.add(val);
            sum = sum + val;
            return sum/queue.size();
        }
    }


    public static void main(String[] args){
        int size = 3;
        MovingAverage obj = new MovingAverage(size);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}
