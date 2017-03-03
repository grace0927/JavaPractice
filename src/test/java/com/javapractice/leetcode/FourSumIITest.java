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

		assertEquals( test.foursumcount(input), 132 );
	}
}
