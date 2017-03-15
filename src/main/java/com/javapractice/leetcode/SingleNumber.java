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
 * https://oj.leetcode.com/problems/single-number/
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int xor = 0;

		for (int i=0; i<nums.length; i++) {
			xor ^= nums[i];
		}

		return xor;
	}
}
