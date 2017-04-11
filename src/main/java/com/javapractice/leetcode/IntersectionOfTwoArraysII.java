/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author feng
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to num2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk,
 * and the memory is limited such that you cannot load all elements into the memory at once?
 *
 */
public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0; i<nums1.length; i++) {
			if(!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			} else {
				map.put(nums1[i], map.get(nums1[i])+1);
			}
		}

		for(int i=0; i<nums2.length; i++) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}

		return convertToArray(list);
	}

	public int[] convertToArray(ArrayList<Integer> array) {
		int[] result = new int[array.size()];
		int i=0;

		for (int j:array) {
			result[i++] = j;
		}

		return result;
	}
}
