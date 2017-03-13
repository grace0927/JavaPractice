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
public class ArithmeticSlicesTest {
	@Test
	public void testNumberOfArithmeticSlices() {
		ArithmeticSlices test = new ArithmeticSlices();

		int[] input = new int[]{ 1, 2, 3, 4 };

		assertArrayEquals(test.numberOfArithmeticSlices(input), 3);
	}
}
