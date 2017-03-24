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
public class ConstructTheRectangleTest {
	@Test
	public void testConstructRectangle() {
		ConstructTheRectangle test = new ConstructTheRectangle();

		int[] expected = new int[]{ 2, 2 };

		assertArrayEquals(test.constructRectangle(4), expected);
	}
}
