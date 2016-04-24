import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mellon on 4/7/16.
 *
 *
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].


 */
public class L341_FlattenNestedListIterator implements Iterator<Integer> {
    private List<NestedInteger> nL;
    private int currentCount;
    private int totalCount;
    private List<Integer> flattenedList;

    public L341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.nL = nestedList;
        currentCount = 0;
        flattenedList = new ArrayList<Integer>();
        doListFlat(nestedList);
        totalCount = flattenedList.size();
    }

    private void doListFlat(List<NestedInteger> NIL){
        if(NIL == null){
            return;
        }
        for(NestedInteger NI : NIL){
            if(NI.isInteger()){
                flattenedList.add(NI.getInteger());
            }
            else{
                doListFlat(NI.getList());
            }
        }
        return;
    }

    @Override
    public Integer next() {
        int ret = flattenedList.get(currentCount);
        currentCount += 1;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return currentCount < totalCount;
    }
}
