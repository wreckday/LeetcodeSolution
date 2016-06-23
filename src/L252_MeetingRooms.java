import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 *
 * Created by Mellon on 5/26/16.
 */
public class L252_MeetingRooms {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }else
                    return o1.start-o2.start;
            }
        };
        Arrays.sort(intervals, comparator);
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i].end>intervals[i+1].start)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Interval meet1 = new Interval(0, 3);
        Interval meet2 = new Interval(0, 2);
        Interval meet3 = new Interval(0, 9);
        Interval[] intervals = {meet1, meet2, meet3};

        System.out.println(canAttendMeetings(intervals));
    }


}
