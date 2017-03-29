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
public class IntersectionOfTwoArraysTest {
	@Test
	public void testFunctionName() {
		IntersectionOfTwoArrays test = new IntersectionOfTwoArrays();

		int[] input1 = new int[]{ 1, 2, 2, 1 };
		int[] input2 = new int[]{ 2, 2 };
		int[] expected = new int[]{ 2 };

		assertArrayEquals( test.intersection( input1, input2 ), expected );
	}
}
