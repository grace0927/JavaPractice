/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 */
public class FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		// init variables
		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		// loop over to find dupes
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i])) {
				list.add(nums[i]);
			}
			set.add(nums[i]);
		}

		return list;
	}

	// using sort
	public List<Integer> findDuplicatesBySort(int[] nums) {
		// init variables
		List<Integer> list = new ArrayList<>();

		// bucket sort
		for(int i=0; i<nums.length; i++) {
			while(nums[i]!=i+1 && nums[i] != nums[nums[i]-1]) {
				swap(nums, i, nums[i]-1);
			}
		}

		// loop over to find dupes
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=i+1) {
				list.add(nums[i]);
			}
		}

		return list;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
