/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * Given [4, 5, 6, 7, 0, 1, 2] return 0
 * You may assume no duplicate exists in the array.
 *
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int len = num.length;
        if(len==1 || num[0]<num[len-1]) {
        	return num[0];
        }
        if(num[len-1] < num[len-2]) {
        	return num[len-1];
        }


        int start = 0;
        int end = len-1;
        while(start < end-1) {
        	int mid = start + (end-start)/2;
        	if(num[mid] < num[mid-1]) {
        		return num[mid];
        	} else if(num[mid] > num[start]){
        		start = mid;
        	} else {
        		end = mid;
        	}
        }

        return (num[end]<num[end-1])?num[end]:num[start];
    }
}
