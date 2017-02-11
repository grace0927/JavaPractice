/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 *
 */
public class SegmentTreeNode {
    SegmentTreeNode left, right;
    int from, to, sum;
    
    public SegmentTreeNode(int from, int to) {
        left = null;
        right = null;
        this.from = from;
        this.to = to;
    }
}
