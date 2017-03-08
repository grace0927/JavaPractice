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
public class IntegerToRomanTest {
	@Test
	public void testIntToRoman() {
		IntegerToRoman test = new IntegerToRoman();

		assertEquals( test.intToRoman(3877), "MMMDCCCLXXVII" );
	}
}
