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
public class CountNumbersWithUniqueDigitsTest {
	@Test
	public void testCountNumbersWithUniqueDigits() {
		CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();

		assertEquals(test.countNumbersWithUniqueDigits(0), 1);
		assertEquals(test.countNumbersWithUniqueDigits(2), 91);
		assertEquals(test.countNumbersWithUniqueDigits(12), 8877691);
	}

	@Test
	public void testCountNumbersWithUniqueDigitsConstantTime() {
		CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();

		assertEquals(test.countNumbersWithUniqueDigitsConstantTime(0), 1);
		assertEquals(test.countNumbersWithUniqueDigitsConstantTime(2), 91);
		assertEquals(test.countNumbersWithUniqueDigitsConstantTime(12), 8877691);
	}
}
