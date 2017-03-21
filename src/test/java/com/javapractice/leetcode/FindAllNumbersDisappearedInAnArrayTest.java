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
public class FindAllNumbersDisappearedInAnArrayTest {
	@Test
	public void testFindDisappearedNumbers() {
		FindAllNumbersDisappearedInAnArray test = new FindAllNumbersDisappearedInAnArray();

		int[] input = new int[]{ 4, 3, 2, 7, 8, 2, 3, 1 };
		int[] expected = new int[]{ 5, 6 };

		assertArrayEquals( test.findDisappearedNumbers(input), expected );
	}
}
