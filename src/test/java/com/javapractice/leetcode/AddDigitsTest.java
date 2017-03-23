/**
 *
 */
package com.javapractice.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jianyu Feng
 *
 */
public class AddDigitsTest {
	@Test
	public void testAddDigits() {
		AddDigits test = new AddDigits();

		assertArrayEquals(test.addDigits(38), 2);
	}
}
