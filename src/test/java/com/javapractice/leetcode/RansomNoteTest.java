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
public class RansomNoteTest {
	@Test
	public void testCanConstruct() {
		RansomNote test = new RansomNote();

		assertTrue( test.canConstruct('a', 'aab') );
	}
}
