/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
          n = n & n - 1;
         }
         return m & n;
    }
    
    public int rangeBitwiseAndMask(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((m&mask)!=(n&mask)) {
            mask <<= 1;
        }
        return m&mask;
    }
}
