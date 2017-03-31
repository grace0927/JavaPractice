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
public class AssignCookiesTest {
	@Test
	public void testFindContentChildren() {
		AssignCookies test = new AssignCookies();

		int[] children = new int[]{ 1, 1 };
		int[] cookies = new int[]{ 1, 2, 3 };

		assertEquals( test.findContentChildren(children, cookies), 2 );
	}
}
