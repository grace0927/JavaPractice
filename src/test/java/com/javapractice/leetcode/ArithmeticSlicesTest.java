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
public class ArithmeticSlicesTest {
	@Test
	public void testNumberOfArithmeticSlices() {
		ArithmeticSlices test = new ArithmeticSlices();

		int[] input = new int[]{ 1, 2, 3, 4 };

		assertEquals(test.numberOfArithmeticSlices(input), 3);
	}
}
