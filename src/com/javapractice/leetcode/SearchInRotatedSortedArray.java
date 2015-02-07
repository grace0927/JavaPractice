/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		if(A[start] == target) {
			return start;
		}
		if(A[end] == target) {
			return end;
		}
		// binary search
		while(end > start+1) {
			int mid = (start+end)/2;
			if(A[mid] == target) {
				return mid;
			}
			if(target > A[start]) {
			    if(A[mid] < target && A[mid] > A[start]) {
			        start = mid;
			    } else {
			        end = mid;
			    }
			} else {
			    if(A[mid] > target && A[mid] < A[start]) {
			        end = mid;
			    } else {
			        start = mid;
			    }
			}
		}
		
		return -1;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
