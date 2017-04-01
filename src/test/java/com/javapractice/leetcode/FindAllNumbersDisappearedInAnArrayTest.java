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
public class FindAllNumbersDisappearedInAnArrayTest {
	@Test
	public void testFindDisappearedNumbers() {
		FindAllNumbersDisappearedInAnArray test = new FindAllNumbersDisappearedInAnArray();

		int[] input = new int[]{ 4, 3, 2, 7, 8, 2, 3, 1 };
		int[] expected = new int[]{ 5, 6 };

		assertEquals( test.findDisappearedNumbers(input), expected );
	}
}
