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
public class CountNumbersWithUniqueDigitsTest {
	@Test
	public void testCountNumbersWithUniqueDigits() {
		CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();

		assertArrayEquals(test.countNumbersWithUniqueDigits(0), 1);
		assertArrayEquals(test.countNumbersWithUniqueDigits(2), 91);
		assertArrayEquals(test.countNumbersWithUniqueDigits(12), 8877691);
	}

	@Test
	public void testCountNumbersWithUniqueDigitsConstantTime() {
		CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();

		assertArrayEquals(test.countNumbersWithUniqueDigitsConstantTime(0), 1);
		assertArrayEquals(test.countNumbersWithUniqueDigitsConstantTime(2), 91);
		assertArrayEquals(test.countNumbersWithUniqueDigitsConstantTime(12), 8877691);
	}
}
