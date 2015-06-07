/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/plus-one/
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 */
public class PlueOne {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
		for(int i=size-1; i>=0; i--) {
			if(digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] += 1;
				break;
			}
			if(i == 0 && digits[0] == 0) {
				int[] result = new int[size+1];
				result[0] = 1;
				for(int j=1; j<size+1; j++) {
					result[j] = digits[j-1];
				}
				return result;
			}
		}
		return digits;
    }

}
