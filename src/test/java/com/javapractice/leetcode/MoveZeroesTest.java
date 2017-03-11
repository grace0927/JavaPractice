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
public class MoveZeroesTest {
	@Test
	public void testMoveZeroes() {
		MoveZeroes test = new MoveZeroes();

		int[] input = new int[]{ 0, 1, 0, 3, 12 };
		int[] expected = new int[]{ 1, 3, 12, 0, 0 };
		test.moveZeroes(input);

		assertArrayEquals( input, expected );
	}
}
