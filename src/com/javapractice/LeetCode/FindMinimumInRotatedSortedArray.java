/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 */
public class FindMinimumInRotatedSortedArray {
	
	public int findMin(int[] num) {
        // special case: array with no element
        if(num == null) {
            return 0;
        }
        // special case: array with one element
        if(num.length == 1) {
            return num[0];
        } 
        
        int start = 0;
        int end = num.length-1;
        
        if(num[start] < num[end]) {
            return num[start];
        }
        if(num[end] < num[end-1]) {
            return num[end];
        }
        
        while(end > start) {
            int mid = (end+start)/2;
            if(num[mid] < num[mid+1] && num[mid] < num[mid-1]) {
                return num[mid];
            } else if(num[mid] > num[mid+1]) {
                return num[mid+1];
            } else if(num[mid] > num[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return num[start];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
