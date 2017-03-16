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
public class NextGreaterElementIITest {
	@Test
	public void testNextGreaterElements() {
		NextGreaterElementII test = new NextGreaterElementII();

		int[] input = new int[]{ 1, 2, 1 };
		int[] expected = new int[]{ 2, -1, 2 };

		assertArrayEquals( test.nextGreaterElements(input), expected );
	}
}
