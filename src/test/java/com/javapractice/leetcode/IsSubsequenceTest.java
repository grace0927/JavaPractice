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
public class IsSubsequenceTest {
	@Test
	public void testIsSubsequence() {
		IsSubsequence test = new IsSubsequence();

		assertFalse( test.isSubsequence("abc", "ahbgd") );
		assertTrue( test.isSubsequence("abc", "ahbgdc") );
	}
}
