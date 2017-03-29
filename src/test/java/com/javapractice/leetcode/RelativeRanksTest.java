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
public class RelativeRanksTest {
	@Test
	public void testFunctionName() {
		RelativeRanks test = new RelativeRanks();

		int[] input = new int[]{ 5, 4, 3, 2, 1 };
		String[] expected = new String[]{ "Gold Medal", "Silver Medal", "Bronze Medal", "4", "5" };

		assertArrayEquals( test.findRelativeRanks(), expected );
	}
}
