/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/super-ugly-number/
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list 
 * primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of 
 * the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] idx = new int[primes.length];
        res[0] = 1;
        
        for(int i=1; i<n; i++) {
            res[i] = Integer.MAX_VALUE;
            
            for(int j=0; j<primes.length; j++) {
                res[i] = Math.min(res[i], primes[j]*res[idx[j]]);
            }
            
            for(int j=0; j<primes.length; j++) {
                if(res[i] == primes[j]*res[idx[j]]) {
                    idx[j]++;
                }
            }
        }
        
        return res[n-1];
    }
}
