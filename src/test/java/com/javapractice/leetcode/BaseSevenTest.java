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
public class BaseSevenTest {
	@Test
	public void testConvertToBase7() {
		BaseSeven test = new BaseSeven();

		assertEquals( test.convertToBase7(100), "202" );
	}
}
