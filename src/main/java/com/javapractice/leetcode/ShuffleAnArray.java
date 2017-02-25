/**
 *
 */
package com.javapractice.leetcode;

import java.util.Random;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/shuffle-an-array/
 * Shuffle a set of numbers without duplicates.
 *
 */
public class ShuffleAnArray {
	private int[] original;
	private int length;
	private Random rand = new Random();

	public ShuffleAnArray(int[] nums) {
		this.length = nums.length;
		this.original = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return original;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] current = new int[length];

		for(int i=0; i<length; i++) {
			int j = rand.nextInt(i+1);
			current[i] = current[j];
			current[j] = original[i];
		}

		return current;
	}
}
