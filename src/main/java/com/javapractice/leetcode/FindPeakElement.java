/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/find-peak-element/
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] �� num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -��.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * Note:
 * Your solution should be in logarithmic complexity.
 *
 */
public class FindPeakElement {
	public int findPeakElementOld(int[] num) {
		if(num == null) {
			// special case 1: array with no elements
			return -1;
		} else if(num.length == 1) {
			// special case 2: array with one element
			return 0;
		} else if(num.length == 2) {
			// specail case 3: array with two elements
			if(num[1] > num[0]) {
				return 1;
			} else {
				return 0;
			}
		} else {
			// initial parameters
			int start = 0;
			int end = num.length-1;

			// check boundary
			if(num[start] > num[start+1]){
				return start;
			}
			if(num[end] > num[end-1]) {
				return end;
			}

			// binary search
			while(start < end) {
				int mid = (start+end)/2;
				if(num[mid] > num[mid+1] && num[mid] > num[mid-1]) {
					return mid;
				} else if(num[mid] < num[mid+1]) {
					start = mid;
				} else if(num[mid] < num[mid-1]) {
					end = mid;
				}
			}
			return start;
		}
	}

	public int findPeakElement(int[] nums) {
		if (nums.length==0) {
			return 0;
		}

		int start=0, end=nums.length-1;
		while (start<end-1) {
			int mid = start+(end-start)/2;
			if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
				return mid;
			}
			if (nums[mid]>nums[mid-1]) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return nums[start]>nums[end] ? start : end;
	}
}
