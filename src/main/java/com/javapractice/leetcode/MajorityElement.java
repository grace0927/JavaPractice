/**
 *
 */
package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author feng
 * https://oj.leetcode.com/problems/majority-element/
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than  n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 */
public class MajorityElement {
	public int majorityElement(int[] num) {
		int size = num.length;
		HashMap<Integer, Integer> count = new HashMap<>();

		for(int i=0; i<size; i++) {
			if(count.containsKey(num[i])) {
				Integer amount = count.get(num[i]);
				if(amount >= size/2) {
					return num[i];
				} else {
					count.put(num[i], new Integer(amount+1));
				}
			} else {
				count.put(num[i], new Integer(1));
			}
		}

		return num[0];
	}

	/*
	 * ref: http://www.programcreek.com/2014/02/leetcode-majority-element-java/
	 */
	public int majorityElementAlter(int[] num) {
		Arrays.sort(num);
		return num[num.length / 2];
	}

	public int majorityElementMajorityVoteAlgorithm(int[] nums) {
		int result = 0, count = 0;

		for(int i = 0; i<nums.length; i++ ) {
			if(count == 0){
				result = nums[ i ];
				count = 1;
			}else if(result == nums[i]){
			   count++;
			}else{
			   count--;
			}
		}

		return result;
	}
}
