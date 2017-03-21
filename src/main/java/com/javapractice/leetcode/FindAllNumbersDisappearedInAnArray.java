/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 *
 */
public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();

		sort(nums);

		for (int i=0; i<nums.length; i++) {
			if (nums[i] != i+1) {
				list.add(i+1);
			}
		}

		return list;
	}

	public void sort(int[] nums) {
		int i=0;
		while (i<nums.length) {
			if (nums[i]==i+1 || nums[nums[i]-1]==nums[i]) {
				i++;
				continue;
			}
			swap(nums, i, nums[i]-1);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public List<Integer> findDisappearedNumbersNegtive(int[] nums) {
		List<Integer> list = new ArrayList<>();

		for (int i=0; i<nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			nums[index] = -Math.abs(nums[index]);
		}

		for (int i=0; i<nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i+1);
			}
		}

		return list;
	}
}
