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
public class KthSmallestElementInASortedMatrixTest {
	@Test
	public void testKthSmallest() {
		int[][] input = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();

		assertEquals( test.kthSmallest(input, 8), 13 );
	}
}
