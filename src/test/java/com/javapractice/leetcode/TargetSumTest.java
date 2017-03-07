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
public class TargetSumTest {
	@Test
	public void testFourSumCount() {
		int[] input = new int[] {1, 1, 1, 1, 1};
		TargetSum test = new TargetSum();

		assertEquals( test.findTargetSumWays(input), 5 );
	}
}
