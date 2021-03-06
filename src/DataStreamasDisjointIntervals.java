import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]
 Follow up:
 What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *
 * Created by Mellon on 7/27/17.
 */
public class DataStreamasDisjointIntervals {
    public static void main(String[] args){
        SummaryRanges2 summaryRanges2 = new SummaryRanges2();
        summaryRanges2.addNum(3);
        //printIntervals(summaryRanges2.getIntervals());
        summaryRanges2.addNum(1);
        //printIntervals(summaryRanges2.getIntervals());
        summaryRanges2.addNum(7);
        printIntervals(summaryRanges2.getIntervals());
//        summaryRanges2.addNum(2);
//        printIntervals(summaryRanges2.getIntervals());
//        summaryRanges2.addNum(6);
//        printIntervals(summaryRanges2.getIntervals());
    }

    public static void printIntervals(List<Interval> intervals){
        for(Interval interval: intervals){
            System.out.print("["+interval.start+",");
            System.out.print(interval.end+"]     ");
        }
    }

}

class SummaryRanges2 {

    private List<Interval> l;
    /** Initialize your data structure here. */
    public SummaryRanges2() {
        l = new ArrayList<Interval>();
    }

    public void addNum(int val) {
        l = insert(l,new Interval(val,val));
    }

    public List<Interval> getIntervals() {
        return l;
    }

    private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for(Interval in: intervals) {
            if(newInterval.end < in.start - 1) {
                res.add(newInterval);
                newInterval = in;
            }else if(newInterval.start > in.end +1) {
                res.add(in);
            }else {
                newInterval = new Interval(Math.min(newInterval.start,in.start),Math.max(newInterval.end,in.end) );
            }
        }
        res.add(newInterval);
        return res;
    }
}

class SummaryRangeTreeMap{
//    Use TreeMap to easily find the lower and higher keys, the key is the start of the interval.
//    Merge the lower and higher intervals when necessary. The time complexity for adding is O(logN) since lowerKey(), higherKey(), put() and remove() are all O(logN). It would be O(N) if you use an ArrayList and remove an interval from it.

    public class SummaryRanges {
        TreeMap<Integer, Interval> tree;
        public SummaryRanges() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if(tree.containsKey(val)) return;
            Integer l = tree.lowerKey(val);
            Integer h = tree.higherKey(val);
            if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1){
                tree.get(l).end = tree.get(h).end;
                tree.remove(h);
            } else if(l != null && tree.get(l).end + 1 >= val) {
                tree.get(l).end = Math.max(tree.get(l).end, val);
            } else if(h != null && h == val + 1) {
                tree.put(val, new Interval(val, tree.get(h).end));
                tree.remove(h);
            } else {
                tree.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(tree.values());
        }
    }
}