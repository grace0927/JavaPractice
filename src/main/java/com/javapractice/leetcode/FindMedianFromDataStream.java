/**
 * 
 */
package com.javapractice.leetcode;

import java.util.PriorityQueue;

/**
 * @author feng
 * Median is the middle value in an ordered integer list. 
 * If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3)
 * findMedian() -> 2
 *
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(-minHeap.poll());
        if(maxHeap.size()>minHeap.size()) {
            minHeap.add(-maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (minHeap.size()>maxHeap.size())?minHeap.peek():(minHeap.peek()-maxHeap.peek())/2.0;
    }
}
