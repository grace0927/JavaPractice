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
public class FirstUniqueCharacterInAStringTest {
	@Test
	public void testFirstUniqChar() {
		FirstUniqueCharacterInAString test = new FirstUniqueCharacterInAString();

		assertEquals( test.firstUniqChar( "leetcode" ), 0 );
	}
}
