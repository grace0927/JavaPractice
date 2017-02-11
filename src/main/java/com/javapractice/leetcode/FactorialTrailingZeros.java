/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n/5 > 0) {
            res += n/5;
            n /= 5;
        }
        return res;
    }

}
