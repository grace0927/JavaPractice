/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/range-sum-query-mutable/
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class NumArrayMutable {
    SegmentTree tree = null;
    
    public NumArrayMutable(int[] nums) {
        tree = new SegmentTree(nums);
    }

    void update(int i, int val) {
        tree.updateSegmentTree(i, val);
    }

    public int sumRange(int i, int j) {
        return tree.sumRange(i, j);
    }
    
    /*
     * using segment tree
     * update O(log n) search O(log n)
     * ref: http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
     * https://leetcode.com/discuss/70202/17-ms-java-solution-with-segment-tree 
   	class SegmentTreeNode {
        SegmentTreeNode left, right;
        int from, to, sum;
        
        SegmentTreeNode(int from, int to) {
            left = null;
            right = null;
            this.from = from;
            this.to = to;
        }
    }
    
    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        SegmentTreeNode root = null;
        if(start > end) {
            return root;
        }
        
        root = new SegmentTreeNode(start, end);
        if(start == end) {
            root.sum = nums[start];
        } else {
            int mid = start + (end-start)/2;
            root.left = buildSegmentTree(nums, start, mid);
            root.right = buildSegmentTree(nums, mid+1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        
        return root;
    }
    
    private void updateSegmentTree(SegmentTreeNode root, int idx, int val) {
        if(root.from == root.to) {
            root.sum = val;
            return ;
        }
        int mid = root.from + (root.to-root.from)/2;
        if(mid >= idx) {
            updateSegmentTree(root.left, idx, val);
        } else {
            updateSegmentTree(root.right, idx, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    private int sumRange(SegmentTreeNode root, int start, int end) {
        if(root.from==start && root.to==end) {
            return root.sum;
        }
        int mid = root.from+(root.to-root.from)/2;
        if(mid >= end) {
            return sumRange(root.left, start, end);
        } else if(mid+1 <= start) {
            return sumRange(root.right, start, end);
        } else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
        }
    } 
    
    SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        updateSegmentTree(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
     */
}
