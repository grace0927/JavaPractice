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
public class BestTimeToBuyAndSellStockIITest {
	@Test
	public void testMaxProfit() {
		BestTimeToBuyAndSellStockII test = new BestTimeToBuyAndSellStockII();

		int[] input = new int[]{ 1, 2 };

		assertEquals( test.maxProfit( input ), 1 );
	}
}
