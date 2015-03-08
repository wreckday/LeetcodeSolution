import java.util.ArrayList;

/**
 * Created by Mellon on 2/25/15.
 *
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals.size()==0)
        {
            res.add(newInterval);
            return res;
        }

        int i=0;
        // continue to add element until finding the end of added elment greater than the start of new element.
        while(i < intervals.size() && intervals.get(i).end < newInterval.start)
        {
            res.add(intervals.get(i));
            i++;
        }
        // then, we found the position to add. But we need to think about merging the start of newInterval
        if(i < intervals.size())
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);

        res.add(newInterval);

        // and then, contiues to loop through the following intervals until the start of added element is greater
        // than the end of the new Interval
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end)
        {
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        // added the rest of elements
        while(i<intervals.size())
        {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        ArrayList<Interval> res = insert(intervals, new Interval(2,5));

        for(Interval e : res){
            System.out.print("{"+e.start +"," + e.end+"}");
        }
    }
}
