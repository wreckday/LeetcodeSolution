import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mellon on 2/22/15.
 */
public class MergeIntervals {
    // 1. implement sort intervals
    // 2. O(nlogn+n)=O(nlogn)，空间复杂度是O(1)，

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)
            return intervals;

        // Anonymous inner classes are very handy
        //when you need to implement an interface which may not be highly reusable
        Comparator<Interval> comp = new Comparator<Interval>()
        {
            @Override
            public int compare(Interval i1, Interval i2)
            {  // point if the starts are the same, then compare end
                if(i1.start==i2.start)
                    return i1.end-i2.end;

                return i1.start-i2.start;
            }
        };

        Collections.sort(intervals, comp);

        res.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++)
        {
            if(res.get(res.size()-1).end>=intervals.get(i).start)
            {
                //{1,4}
                //{4,7}  ==> {1,7}

                //{1,4}
                //{2,8} ==> {1,8}

                // point: get the last list in the res   (res.size()-1).
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
            }
            else
            {   //{1,4}
                //{5,7} ==> {1,4} {5,7}
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }