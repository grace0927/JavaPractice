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
public class ReconstructOriginalDigitsFromEnglishTest {
	@Test
	public void testOriginalDigits() {
		ReconstructOriginalDigitsFromEnglish test = new ReconstructOriginalDigitsFromEnglish();

		assertEquals( test.originalDigits("fviefuro"), "45" );
	}
}
