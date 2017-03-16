/**
 *
 */
package com.javapractice.leetcode;

import java.util.Arrays;

/**
 * @author feng
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Given an array nums containing n + 1 integers where each integer is
 * between 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 */
public class FindTheDuplicateNumber {
	// O(nlogn)
	public int findDuplicateSort(int[] nums) {
		Arrays.sort(nums);

		for(int i=1; i<nums.length; i++) {
			if(nums[i]==nums[i-1]) {
				return nums[i];
			}
		}

		return 0;
	}

	// O(n) with two pointer, similar to find cycle in linked list
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];

		while(slow!=fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while(slow!=fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

	// O(n) HashSet
	public int findDuplicateHashSet(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

		for (int i=0; i<nums.length; i++) {
			if (set.contains(nums[i])) {
				return nums[i];
			}
			set.add(nums[i]);
		}

		return 0;
	}
}
