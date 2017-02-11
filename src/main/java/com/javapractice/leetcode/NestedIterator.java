/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author feng
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- 
 * whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,4,6].
 *
 */
public class NestedIterator implements Iterator<Integer> {
    LinkedList<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }
    
    private void helper(List<NestedInteger> nestedList) {
        for(NestedInteger i:nestedList) {
            if(!i.isInteger()) {
                helper(i.getList());
            } else {
                queue.add(i.getInteger());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
