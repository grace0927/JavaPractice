/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/number-of-1-bits/
 * Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ¡¯11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 */
public class NumberOfOneBits {
	public int hammingWeight(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            res += n&1;
            n >>>= 1;
        }
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
