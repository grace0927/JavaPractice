/**
 *
 */
package com.javapractice.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Jianyu Feng
 *
 */
public class MinimumMovesToEqualArrayElementsTest {
	@Test
	public void testMinMoves() {
		MinimumMovesToEqualArrayElements test = new MinimumMovesToEqualArrayElements();

		int[] input = new int[]{ 1, 2, 3 };

		assertEquals( test.minMoves(input), 3);
	}
}
