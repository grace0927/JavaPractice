/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/sum-of-two-integers/
 * Calculate the sum of two integers a and b,
 * but you are not allowed to use the operator + and -.
 *
 */
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		int res=0, over=0;

		for(int i=0; i<32; i++) {
			int ai=((a>>i)&1), bi=((b>>i)&1);

			if(ai==1 && bi==1) {
				if(over==1) {
					res += (1<<i);
				}
				over = 1;
			} else if(ai==1 || bi==1) {
				if(over!=1) {
					res += (1<<i);
				}
			} else if(over==1) {
				res += (1<<i);
				over = 0;
			}
		}

		return res;
	}

	public int getSumBit(int a, int b) {
		int res=0, carryover=0;

		for (int i=0; i<32; i++) {
			int aDigit=(a>>i)&1, bDigit=(b>>i)&1, cDigit=0;

			if ((aDigit^bDigit)==0) {
				cDigit = carryover;
				carryover = aDigit&bDigit;
			} else {
				cDigit = carryover^1;
			}

			res += (cDigit<<i);
		}

		return res;
	}
}
