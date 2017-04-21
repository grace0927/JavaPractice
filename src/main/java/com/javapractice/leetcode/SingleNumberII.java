package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/single-number-ii/
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

public class SingleNumberII {
	public int singleNumber(int[] A) {
		int size = A.length;
		int[] bin = new int[32];
		int result=0;

		for(int i=0; i<32; i++) {
			for(int j=0; j<size; j++) {
				bin[i] += (A[j]>>i & 1);
			}
			result |= ((bin[i]%3)<<i);
		}

		return result;
	}

	public int singleNumberHashMap(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i:nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}

		for (int i:map.keySet()) {
			if (map.get(i)==1) {
				return i;
			}
		}

		return 0;
	}

	//https://discuss.leetcode.com/topic/11877/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
	public int singleNumberBitwise(int[] A) {
		int ones = 0, twos = 0;
		for(int i = 0; i < A.length; i++){
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}
}
