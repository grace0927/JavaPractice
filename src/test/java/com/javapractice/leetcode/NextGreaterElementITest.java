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
public class NextGreaterElementITest {
	@Test
	public void testNextGreaterElement() {
		NextGreaterElementI test = new NextGreaterElementI();

		int[] nums = new int[]{ 1, 3, 4, 2 };
		int[] findNums = new int[]{ 4, 1, 2 };
		int[] expected = new int[]{ -1, 3, -1 };

		assertArrayEquals( test.nextGreaterElement(findNums, nums), expected );
	}
}
