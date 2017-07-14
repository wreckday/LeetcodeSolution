import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 *
 * Created by Mellon on 5/26/16.
 */
public class L253_MeetingRoomsII {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // sort
        Arrays.sort(intervals, (a, b)->(a.start-b.start));
        // PriorityQueue
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (Interval cur_interval : intervals) {
            if (!ends.isEmpty() && cur_interval.start >= ends.peek()) { // no overlap, then should update smallest end.
                ends.poll();
            }
            ends.offer(cur_interval.end);
        }
        return ends.size();
    }

    public static int minMeetingRoomsGood(Interval[] intervals) {
        //Just want to share another idea that uses min heap, average time complexity is O(nlogn).
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }


    public static void main(String[] args){

        Interval meet2 = new Interval(4, 9);
        Interval meet3 = new Interval(4, 17);
        Interval meet1 = new Interval(9, 19);
        Interval meet4 = new Interval(16, 17);
        Interval[] intervals = {meet1, meet2, meet3, meet4};

        System.out.println(minMeetingRooms(intervals));
        System.out.println(minMeetingRoomsGood(intervals));
    }
}
