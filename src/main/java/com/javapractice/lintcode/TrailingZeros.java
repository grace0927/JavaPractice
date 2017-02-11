/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author feng
 * http://www.lintcode.com/en/problem/trailing-zeros/
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * 11! = 39916800, so the out should be 2
 * O(log N) time
 *
 */
public class TrailingZeros {
	/*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long cnt = 0;
        while(n/5 > 0) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }
}
