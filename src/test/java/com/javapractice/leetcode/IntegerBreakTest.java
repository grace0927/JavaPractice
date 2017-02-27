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
public class IntegerBreakTest {
	@Test
	public void testIntegerBreak() {
		IntegerBreak test = new IntegerBreak();

		assertEquals(test.integerBreak(2), 1);
		assertEquals(test.integerBreak(10), 36);
		assertEquals(test.integerBreak(16), 324);
	}

	@Test
	public void testIntegerBreakDP() {
		IntegerBreak test = new IntegerBreak();

		assertEquals(test.integerBreakDP(2), 1);
		assertEquals(test.integerBreakDP(10), 36);
		assertEquals(test.integerBreakDP(16), 324);
	}
}
