/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/search-for-a-range/
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[]{-1,-1};
        if(A.length <=0 || A[A.length-1] < target || A[0] > target) {
			return result;
		}
		
		if(A.length == 1) {
		    if(A[0] == target) {
		        result[0] = 0;
		        result[1] = 0;
		        return result;
		    }
			return result;
		}
		
		// find start
		if(A[0] == target) {
			result[0] = 0;
		} else {
			int start = 0;
			int end = A.length - 1;
			
			if(A[end]==target && A[end] > A[end-1]) {
			    result[0] = end;
			    result[1] = end;
				return result;
			}
			while(end > start+1) {
				int mid = (start+end)/2;
				if(A[mid] == target) {
					if(A[mid] > A[mid-1]) {
						result[0] = mid;
						start = end;
					} else {
						end = mid;
					}
				} else if(A[mid] > target) {
					end = mid;
				} else {
					start = mid;
				}
			}
		}

		if(result[0] == -1) {
		    return result;
		}
		
		// find end
		if(A[A.length - 1] == target) {
			result[1] = A.length - 1;
		} else {
			int start = 0;
			int end = A.length - 1;
			
			if(A[start]==target && A[start] < A[start+1]) {
			    result[0] = start;
			    result[1] = start;
				return result;
			}
			while(end > start+1) {
				int mid = (start+end)/2;
				if(A[mid] == target) {
					if(A[mid] < A[mid+1]) {
						result[1] = mid;
						start = end;
					} else {
						start = mid;
					}
				} else if(A[mid] > target) {
					end = mid;
				} else {
					start = mid;
				}
			}
		}
		
		return result;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
