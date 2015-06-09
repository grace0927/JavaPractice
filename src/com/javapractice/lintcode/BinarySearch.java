/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/binary-search/
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * If the count of numbers is bigger than 2^32, can your code work properly?
 *
 */
public class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        long len = nums.length;
        if(len==0 || target>nums[nums.length-1] || target<nums[0]) {
        	return -1;
        }

        long start = 0;
        long end = len-1;
        if(target == nums[0]) {
        	return 0;
        }
        if(target == nums[nums.length-1]) {
        	return (int)nums.length-1;
        }
        while(start < end-1) {
        	long mid = start + (end-start)/2;
        	if(target == nums[(int)mid]) {
        		if(nums[(int)mid-1] == target) {
        			end = mid;
        		} else {
        			return (int)mid;
        		}
        	} else if(target > nums[(int)mid]) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }

        return (target==nums[(int)end])?(int)end:-1;
    }
}
