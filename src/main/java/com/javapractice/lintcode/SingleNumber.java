
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/single-number/
 * Using O(1) time to check whether an integer n is a power of 2.
 * Given [1,2,2,1,3,4,3], return 4
 * One-pass, constant extra space.
 *
 */
public class SingleNumber {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for(int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}
}
