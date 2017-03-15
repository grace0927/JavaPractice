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
public class SingleNumberTest {
	@Test
	public void testSingleNumber() {
		SingleNumber test = new SingleNumber();

		int[] input = new int[]{ 1, 2, 2 };

		assertArrayEquals(test.singleNumber(input), 1);
	}
}
