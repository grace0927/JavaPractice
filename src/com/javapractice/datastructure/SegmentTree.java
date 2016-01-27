/**
 * 
 */
package com.javapractice.datastructure;

/**
 * @author Feng
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 *
 */
public class SegmentTree implements DataStructure{
	int[] tree;
	int size;
	int height;
	int length;
	
	public SegmentTree() {
	}
	
	public void init(int[] arr) {
		length = arr.length;
		height = (int) (Math.ceil(Math.log(arr.length)/Math.log(2)));
		size = 2*((int) Math.pow(2, height))-1;
		tree = new int[size];
		buildTree(arr, 0, arr.length-1, 0);
	}
	
	private int buildTree(int[] arr, int start, int end, int idx) {
		if(start==end) {
			tree[idx] = arr[start];
			return tree[idx];
		}
		/*
		 *  store sum of left subtree at idx*2+1
		 *  store sum of right subtree at idx*2+2
		 *  return node value which represent the sum of its subtrees.
		 */
		int mid = start + (end-start)/2;
		tree[idx] = buildTree(arr, start, mid, idx*2+1) + 
				buildTree(arr, mid+1, end, idx*2+2);
		return tree[idx];
	}
	
	public void display() {
		if(tree == null) {
			return ;
		}
		for(int i=0; i<tree.length; i++) {
			System.out.println(tree[i]);
		}
	}
	
	public int getSum(int start, int end) throws RuntimeException {
		if(start<0 || end >length-1) {
			throw new RuntimeException("Invalid Input");
		}
		return getSumUtil(0, length-1, start, end, 0);
	}
	
	private int getSumUtil(int treeStart, int treeEnd, int start, int end, int idx) {
		if(start<=treeStart && end>=treeEnd) {
			return tree[idx];
		}
		if(start>treeEnd || end<treeStart) {
			return 0;
		}
		int mid = treeStart+(treeEnd-treeStart)/2;
		return getSumUtil(treeStart, mid, start, end, idx*2+1) + 
				getSumUtil(mid+1, treeEnd, start, end, idx*2+2);
	}
	
	public void update(int[] arr, int i, int val) throws RuntimeException{
		if(i<0 || i>arr.length) {
			throw new RuntimeException("Invalid Input");
		}
		int diff = val - arr[i];
		updateUtil(0, arr.length-1, i, diff, 0);
	}
	
	private void updateUtil(int start, int end, int ui, int diff, int idx) {
		if(start>ui || end<ui) {
			return ;
		}
		tree[idx] += diff;
		if(start != end) {
			int mid = start + (end-start)/2;
			updateUtil(start, mid, ui, diff, idx*2+1);
			updateUtil(mid+1, end, ui, diff, idx*2+2);
		}
	}
	
	public void run() {
		int[] arr = {1, 3, 5, 7, 9, 11};
		this.init(arr);
		System.out.println(this.getSum(1, 3));
		this.update(arr, 1, 10);
		System.out.println(this.getSum(1, 3));
	}
}
