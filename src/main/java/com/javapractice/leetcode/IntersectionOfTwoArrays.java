/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashSet;

/**
 * @author Feng
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.The result can be in any order.
 *
 */
public class IntersectionOfTwoArrays {
	public int[] intersectionOld(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<nums1.length; i++) {
			set.add(nums1[i]);
		}

		HashSet<Integer> res = new HashSet<>();
		for(int i=0; i<nums2.length; i++) {
			if(set.contains(nums2[i])) {
				res.add(nums2[i]);
			}
		}

		int[] arr = new int[res.size()];
		int pnt = 0;
		for(int i:res) {
			arr[pnt++] = i;
		}

		return arr;
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();

		for (int i:nums1) {
			set1.add(i);
		}

		for (int i:nums2) {
			if (set1.contains(i)) {
				set2.add(i);
			}
		}

		return toArray(set2);
	}

	public int[] toArray(HashSet<Integer> set) {
		int[] result = new int[set.size()];
		int i = 0;

		for (int j:set) {
			result[i++] = j;
		}

		return result;
	}
}
