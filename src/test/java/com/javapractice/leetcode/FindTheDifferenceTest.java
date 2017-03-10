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
public class FindTheDifferenceTest {
	@Test
	public void testFindTheDifference() {
		FindTheDifference test = new FindTheDifference();

		assertEquals( test.findTheDifference("abcd", "abcde"), 'e' );
	}
}
