/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/power-of-two/
 * Given an integer, write a function to determine if it is a power of two.
 *
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int cnt = 0;
        
        while(n>0) {
            if((n&1) == 1) {
                cnt++;
            }
            n>>=1;
        }
        
        return cnt==1;
    }
}
