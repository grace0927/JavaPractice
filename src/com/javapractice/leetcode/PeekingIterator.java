/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Feng
 * https://leetcode.com/problems/peeking-iterator/
 * Given an Iterator class interface with methods: next() and hasNext(), design and 
 * implement a PeekingIterator that support the peek() operation -- 
 * it essentially peek() at the element that will be returned by the next call to next().
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element. 
 * Calling hasNext() after that should return false.
 *
 */
public class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while(iterator.hasNext()) {
	        queue.add(iterator.next());
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return queue.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return queue.poll();
	}

	@Override
	public boolean hasNext() {
	    return !queue.isEmpty();
	}
	
	@Override
	public void remove() {
		
	}
	
	/*    
	 * guava: https://github.com/google/guava/blob/703ef758b8621cfbab16814f01ddcc5324bdea33/
	 * guava-gwt/src-super/com/google/common/collect/super/com/google/common/collect/Iterators.java#L1125
	private final Iterator<Integer> iterator;
    private boolean hasPeek;
    private Integer peekElement;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    hasPeek = false;
	    peekElement = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasPeek) {
            peekElement = iterator.next();
            hasPeek = true;
        }
        return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!hasPeek) {
	        return iterator.next();
	    }
	    hasPeek = false;
	    return peekElement;
	}

	@Override
	public boolean hasNext() {
	    return hasPeek || iterator.hasNext();
	}
	*/
}
