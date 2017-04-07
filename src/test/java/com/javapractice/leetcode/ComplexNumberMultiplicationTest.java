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
public class ComplexNumberMultiplicationTest {
	@Test
	public void testComplexNumberMultiply() {
		ComplexNumberMultiplication test = new ComplexNumberMultiplication();

		assertEquals( test.complexNumberMultiply( "1+1i", "1+1i" ), "0+2i" );
	}
}
