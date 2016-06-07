/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feng
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., 
 * summarize the numbers seen so far as a list of disjoint intervals.
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., 
 * then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small 
 * compared to the data stream's size?
 *
 */
public class DataStreamAsDisjointIntervals {
    class IntervalNode {
        Interval val;
        IntervalNode left, right;
        public IntervalNode(int s, int e) {
            val = new Interval(s, e);
            left = null;
            right = null;
        }
    }

    private IntervalNode root;
    
    public void addNum(int val) {
        if(root==null) {
            root = new IntervalNode(val, val);
            return ;
        }
        addNode(root, val);
    }
    
    private void addNode(IntervalNode root, int val) {
        if(val==root.val.end+1) {
            root.val.end = val;
            mergeRight(root);
        } else if(val==root.val.start-1) {
            root.val.start = val;
            mergeLeft(root);
        } else if(val>root.val.end+1) {
            if(root.right==null) {
                root.right = new IntervalNode(val, val);
            } else {
                addNode(root.right, val);
            }
        } else if(val<root.val.start-1) {
            if(root.left==null) {
                root.left = new IntervalNode(val, val);
            } else {
                addNode(root.left, val);
            }
        }
    }
    
    private void mergeRight(IntervalNode root) {
        if(root.right==null) {
            return ;
        }
        IntervalNode pre = root;
        IntervalNode right=root.right;
        while(right.left!=null) {
            pre = right;
            right = right.left;
        }
        if(root.val.end==right.val.start-1) {
            root.val.end = right.val.end;
            if(pre==root) {
                pre.right = right.right;
            } else {
                pre.left = right.right;
            }
        }
    }
    
    private void mergeLeft(IntervalNode root) {
        if(root.left==null) {
            return ;
        }
        IntervalNode pre = root;
        IntervalNode left=root.left;
        while(left.right!=null) {
            pre = left;
            left = left.right;
        }
        if(root.val.start==left.val.end+1) {
            root.val.start = left.val.start;
            if(pre==root) {
                pre.left = left.left;
            } else {
                pre.right = left.left;
            }
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    
    private void helper(IntervalNode root, List<Interval> list) {
        if(root!=null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }
}
