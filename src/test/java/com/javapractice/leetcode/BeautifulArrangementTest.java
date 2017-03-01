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
public class BeautifulArrangementTest {
	@Test
	public void testBeautifulArrangement() {
		BeautifulArrangement test = new BeautifulArrangement();

		assertEquals(test.countArrangement(1), 1);
		assertEquals(test.countArrangement(2), 2);
		assertEquals(test.countArrangement(8), 132);
	}

	@Test
	public void testIsValid() {
		BeautifulArrangement test = new BeautifulArrangement();

		assertTrue(test.isValid(1, 3));
		assertTrue(test.isValid(3, 1));
		assertFalse(test.isValid(2, 3));
	}
}
