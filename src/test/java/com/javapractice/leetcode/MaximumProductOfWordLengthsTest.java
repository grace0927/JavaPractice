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
public class MaximumProductOfWordLengthsTest {
	@Test
	public void testMaxProduct() {
		MaximumProductOfWordLengths test = new MaximumProductOfWordLengths();
        String[] words = new String[]{ "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };

		assertEquals( test.maxProduct( words ), 16 );
	}
}
