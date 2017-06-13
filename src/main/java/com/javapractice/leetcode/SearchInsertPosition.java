/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.leetcode;

/**
 *
 * @author Jianyu Feng
 *
 * https://oj.leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int index = 0;
		for(index = 0; index < A.length; index++) {
			if(target < A[index]) {
				break;
			} else if(target == A[index]){
				break;
			} else {
				continue;
			}
		}
		return index;
	}

	public int searchInsertBinarySearch(int[] nums, int target) {
		if (nums.length==0 || target<=nums[0]) {
			return 0;
		}
		if (target>nums[nums.length-1]) {
			return nums.length;
		}

		int start=0, end=nums.length;
		while (start<end-1) {
			int mid = start+(end-start)/2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		return end;
	}
}
