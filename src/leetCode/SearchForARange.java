/**
 * 
 */
package leetCode;

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
        if(A.length <=0 || A[A.length-1] < target || A[0] > target) {
			return new int[]{-1, -1};
		}
		
		if(A.length == 1) {
			return (A[0] == target)?new int[]{0,0}:new int[]{-1,-1};
		}
		
		int startTarget = -1;
		int endTarget = -1;
		
		// find start
		if(A[0] == target) {
			startTarget = 0;
		} else {
			int start = 0;
			int end = A.length - 1;
			
			if(A[end]==target && A[end] > A[end-1]) {
				return new int[]{end, end};
			}
			while(end > start+1) {
				int mid = (start+end)/2;
				if(A[mid] == target) {
					if(A[mid] > A[mid-1]) {
						startTarget = mid;
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
		
		// find end
		if(A[A.length - 1] == target) {
			endTarget = A.length - 1;
		} else {
			int start = 0;
			int end = A.length - 1;
			
			if(A[start]==target && A[start] < A[start+1]) {
				return new int[]{start, start};
			}
			while(end > start+1) {
				int mid = (start+end)/2;
				if(A[mid] == target) {
					if(A[mid] < A[mid+1]) {
						endTarget = mid;
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
		
		return new int[]{startTarget, endTarget};
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
