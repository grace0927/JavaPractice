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
	public void testDecodeEncode() {
		EncodeAndDecodeTinyURL test = new EncodeAndDecodeTinyURL();
		String testUrl = "https://foo_url/tinyurl";

		assertEquals( test.decode( test.encode(testUrl) ), testUrl );
	}
}
