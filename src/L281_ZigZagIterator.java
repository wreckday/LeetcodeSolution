import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:
 v1 = [1, 2] v2 = [3, 4, 5, 6]

 By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 [1,2,3] [4,5,6,7] [8,9]
 It should return [1,4,8,2,5,9,3,6,7].

 *
 * Created by Mellon on 1/23/17.
 */
public class L281_ZigZagIterator {
    /*
    Uses a linkedlist to store the iterators in different vectors.
    Every time we call next(), we pop an element from the list,
    and re-add it to the end to cycle through the lists.
    * */
    Queue<Iterator> q;
    public L281_ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList();
        if (!v1.isEmpty()) q.offer(v1.iterator());
        if (!v2.isEmpty()) q.offer(v2.iterator());
    }

    public int next() {
        Iterator cur = q.poll();
        int res = (int) cur.next();
        if (cur.hasNext()) q.offer(cur);
        return res;
    }

    public boolean hasNext() {
        return q.peek() != null;
    }
}
