import java.util.Iterator;

/**
 * Created by dave on 2015/9/24.
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int value;
    boolean isValid;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        value = -1;
        isValid = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(isValid)
            return value;
        int val = iterator.next();
        value = val;
        isValid = true;
        return val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(isValid){
            isValid = false;
            return value;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if(isValid)
            return true;
        return iterator.hasNext();
    }
}
