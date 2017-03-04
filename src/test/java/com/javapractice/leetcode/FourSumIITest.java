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
public class FourSumIITest {
	@Test
	public void testFourSumCount() {
		int[][] input = new int[][] { {-1,1,1,1,-1}, {0,-1,-1,0,1}, {-1,-1,1,-1,-1}, {0,1,0,-1,-1} };
		FourSumII test = new FourSumII();

		assertEquals( test.fourSumCount(input[0], input[1], input[2], input[3]), 132 );
	}
}
