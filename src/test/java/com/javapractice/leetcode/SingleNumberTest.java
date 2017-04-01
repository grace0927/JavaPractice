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
public class SingleNumberTest {
	@Test
	public void testSingleNumber() {
		SingleNumber test = new SingleNumber();

		int[] input = new int[]{ 1, 2, 2 };

		assertEquals(test.singleNumber(input), 1);
	}
}
