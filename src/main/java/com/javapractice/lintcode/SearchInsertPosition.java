/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * O(log(n)) time
 *
 */
public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        int start = 0;
        int end = A.length-1;
        
        if(A.length==0 || target <= A[0]) {
        	return 0;
        } else if(target >= A[end]) {
        	return (target==A[end])?A.length-1:A.length;
        }

        while(start < end-1) {
        	int mid = start + (end-start)/2;
        	if(A[mid] == target) {
        		return mid;
        	} else if(A[mid] > target) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }

        return end;
    }
}
