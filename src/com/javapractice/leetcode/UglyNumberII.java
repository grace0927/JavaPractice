/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/ugly-number-ii/
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * ref: http://www.geeksforgeeks.org/ugly-numbers/
 *
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] idx = new int[]{0, 0, 0};
        int[] base = new int[]{2, 3, 5};
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++) {
            res[i] = Math.min(base[0]*res[idx[0]], Math.min(base[1]*res[idx[1]], base[2]*res[idx[2]]));
            for(int j=0; j<3; j++) {
                if(res[i] == base[j]*res[idx[j]]) {
                    idx[j]++;
                }
            }
        }
        return res[n-1];
    }
}
