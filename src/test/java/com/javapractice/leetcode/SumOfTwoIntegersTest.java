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
public class SumOfTwoIntegersTest {
	@Test
	public void testGetSum() {
		SumOfTwoIntegers test = new SumOfTwoIntegers();

		assertEquals( test.getSum(1, 2), 3 );
	}
}
