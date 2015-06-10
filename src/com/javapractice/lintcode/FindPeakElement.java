/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/find-peak-element/
 * There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peek if:
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * The array may contains multiple peeks, find any of them.
 * Time complexity O(logN)
 *
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int len = A.length;
        if(len == 0 || A[0] > A[1]) {
        	return 0;
        }
		if(A[len-1] > A[len-2]) {
			return len-1;
		}
		int start = 0;
		int end = len-1;
		while(start < end-1) {
			int mid = start + (end-start)/2;
			if(A[mid]>A[mid-1] && A[mid]>A[mid+1]) {
				return mid;
			} else if(A[mid] < A[mid+1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return start;
    }
}
