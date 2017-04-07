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
public class LongestPalindromeTest {
	@Test
	public void testLongestPalindrome() {
		LongestPalindrome test = new LongestPalindrome();

		assertEquals( test.longestPalindrome("abccccdd"), 7 )
	}
}
