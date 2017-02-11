/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/divide-two-integers/
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 *
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
        
        long dvd = (long) dividend;
        long dvs = (long) divisor;
        
		boolean neg = false;
		if(dvd < 0) {
			neg ^= true;
			dvd = -dvd;
		}
		if(dvs < 0) {
			neg ^= true;
			dvs = -dvs;
		}
		long resValue = 0;
		long resIndex = 0;
		
		while(resValue <= dvd-dvs) {
			long cur = 0;
			long next = dvs;
			long start = 0;
			long end = 1;
			while(resValue <= dvd-next) {
				start = end;
				cur = next;
				next += next;
				end += end;
			}
			resValue += cur;
			resIndex += start;
		}
		
		if(neg) {
			resIndex = -resIndex;
		}
		if(resIndex > Integer.MAX_VALUE || resIndex < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		return (int)resIndex;
    }
}
