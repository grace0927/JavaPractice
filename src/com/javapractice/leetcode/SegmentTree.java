/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 *
 */
public class SegmentTree {
	SegmentTreeNode root;
	
	public SegmentTree(int[] nums) {
		root = buildSegmentTree(nums, 0, nums.length-1);
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
    
    public void updateSegmentTree(int idx, int val) {
        if(root.from == root.to) {
            root.sum = val;
            return ;
        }
        int mid = root.from + (root.to-root.from)/2;
        if(mid >= idx) {
            updateSegmentTree(idx, val);
        } else {
            updateSegmentTree(idx, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int start, int end) {
        if(root.from==start && root.to==end) {
            return root.sum;
        }
        int mid = root.from+(root.to-root.from)/2;
        if(mid >= end) {
            return sumRange(start, end);
        } else if(mid+1 <= start) {
            return sumRange(start, end);
        } else {
            return sumRange(start, mid) + sumRange(mid+1, end);
        }
    }
}
