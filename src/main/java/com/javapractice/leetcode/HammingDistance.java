/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/hamming-distance/
 * The Hamming distance between two integers is the number of positions 
 * at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 *
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int z=x^y, cnt=0;
		while(z>0) {
			cnt += z&1;
			z >>= 1;
		}
		return cnt;
	}
}
