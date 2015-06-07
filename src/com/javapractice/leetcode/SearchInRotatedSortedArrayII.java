/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 *
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A.length == 0) {
			return false;
		}
		
		int start = 0;
		int end = A.length - 1;
		if(A[start] == target || A[end] == target) {
			return true;
		}
		
		while(end > start+1) {
			int mid = (start+end)/2;
			if(A[mid] == target) {
				return true;
			}
			if(A[mid] > A[start]) {
				if(A[mid] > target && target > A[start]) {
					end = mid;
				} else {
					start = mid;
				}
			} else if(A[mid] < A[start]) {
				if(A[mid] < target && target < A[start]) {
					start = mid;
				} else {
					end = mid;
				}
			} else {
				start++;
			}
			if(A[start] == target) {
				return true;
			}
		}
		
		return false;
    }
}
