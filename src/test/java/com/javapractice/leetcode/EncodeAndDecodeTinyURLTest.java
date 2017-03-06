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
public class EncodeAndDecodeTinyURLTest {
	@Test
	public void testFourSumCount() {
		EncodeAndDecodeTinyURL test = new EncodeAndDecodeTinyURL();
		String testUrl = "https://foo_url/tinyurl";

		assertEquals( test.decode(this.encode(testUrl)), testUrl );
	}
}
