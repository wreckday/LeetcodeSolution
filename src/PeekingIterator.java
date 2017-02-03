import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

 Hint:

 Think of "looking ahead". You want to cache the next element.
 Is one variable sufficient? Why or why not?
 Test your design with call order of peek() before next() vs next() before peek().
 For a clean implementation, check out Google's guava library source code.
 Follow up: How would you extend your design to be generic and work with all types, not just integer?
 * Created by Mellon on 1/25/17.
 */

class PeekingIteratorImpl<E> implements Iterator<E> {
    private final Iterator<? extends E> iterator;
    private boolean hasPeeked;
    private E peekedElement;

    public PeekingIteratorImpl(Iterator<? extends E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }

    @Override
    public E next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        E result = peekedElement;
        hasPeeked = false;
        peekedElement = null;
        return result;
    }

    public E peek() {
        if (!hasPeeked) {
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
    }
}

public class PeekingIterator{

    public static void main(String[] args){

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        PeekingIteratorImpl peekingIterator = new PeekingIteratorImpl(integerList.iterator());
//        System.out.println(peekingIterator.peek());
//        System.out.println(peekingIterator.next());
//        System.out.println(peekingIterator.next());


        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
    }
}