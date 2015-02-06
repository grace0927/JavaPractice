/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/powx-n/
 * Implement pow(x, n).
 *
 */
public class Powxn {
	public double pow(double x, int n) {
        double result = 1;
        if(n == 0) {
            return result;
        }
        boolean negative = false;
        if(n < 0) {
            negative = true;
            n *= -1;
        }
        result = pow(x, n/2);
        result *= result;
        if(n%2 != 0) {
            result *= x;
        }
        if(negative) {
            result = 1/result;
        }
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
