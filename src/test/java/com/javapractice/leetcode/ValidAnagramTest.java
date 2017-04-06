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
public class ValidAnagramTest {
	@Test
	public void testIsAnagram() {
		ValidAnagram test = new ValidAnagram();

		assertTrue( test.isAnagram("ab", "ba") );
	}
}
