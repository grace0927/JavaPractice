/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * O(logN) time
 *
 */
public class SearchInRotatedSortedArray {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int len = A.length;
        if(len == 0) {
        	return -1;
        }

        if(A[0] == target) {
        	return 0;
        }
        if(A[len-1] == target) {
        	return len-1;
        }

        int start = 0;
        int end = len-1;
        while(start < end-1) {
        	int mid = start+(end-start)/2;
        	if(A[mid] == target) {
        		return mid;
        	} else if((target>A[start]&&A[mid]>target) || (target>A[start]&&A[mid]<A[start]) || (A[mid]<A[start] && A[mid]>target)) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        return (A[start]==target)?start:-1;
    }
}
