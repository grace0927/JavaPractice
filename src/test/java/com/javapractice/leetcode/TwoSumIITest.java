/**
 *
 */
package com.javapractice.leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author Jianyu Feng
 *
 */
public class TwoSumIITest {
	@Test
	public void testTwoSum() {
		TwoSumII test = new TwoSumII();

		int[] input = new int[]{ 2, 2 };
		int[] expected = new int[]{ 1, 2 };

		assertArrayEquals(test.twoSum(input, 4), expected);
	}
}
