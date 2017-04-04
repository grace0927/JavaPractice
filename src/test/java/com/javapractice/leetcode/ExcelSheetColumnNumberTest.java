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
public class ExcelSheetColumnNumberTest {
	@Test
	public void testFunctionName() {
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();

		assertEquals( test.titleToNumber("BAC"), 1381 );
	}
}
