import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * <p>
 * Created by Mellon on 5/12/17.
 */
public class FlattenNestedListIterator {
    /*
    In my opinion an iterator shouldn't copy the entire data
    (which some solutions have done) but just iterate over the original data structure.

    I keep the current progress in a stack. My hasNext tries to find an integer.
    My next returns it and moves on. I call hasNext in next because hasNext is optional.
    Some user of the iterator might call only next and never hasNext,
    e.g., if they know how many integers are in the structure
    or if they want to handle the ending with exception handling.
    * */

    public class NestedIterator implements Iterator<Integer> {

        private Stack<ListIterator<NestedInteger>> lists;

        public NestedIterator(List<NestedInteger> nestedList) {
            lists = new Stack<>();
            lists.push(nestedList.listIterator());
        }

        public Integer next() {
            hasNext();
            return lists.peek().next().getInteger();
        }

        public boolean hasNext() {
            while (!lists.empty()) {
                if (!lists.peek().hasNext()) {
                    lists.pop();
                } else {
                    NestedInteger x = lists.peek().next();
                    if (x.isInteger()) {
                        lists.peek().previous();
                        return true;
                    }

                    lists.push(x.getList().listIterator());
                }
            }
            return false;
        }
    }
 }
