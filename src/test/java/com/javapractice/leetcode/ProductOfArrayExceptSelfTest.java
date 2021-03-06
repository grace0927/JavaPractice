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
public class ProductOfArrayExceptSelfTest {
	@Test
	public void testProductExceptSelf() {
		ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();

		int[] input = new int[]{ 1, 2, 3, 4 };
		int[] expected = new int[]{ 24, 12, 8, 6 };
		int[] result = test.productExceptSelf(input);

		assertArrayEquals(expected, result);
	}
}
