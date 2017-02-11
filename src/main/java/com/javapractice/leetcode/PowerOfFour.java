/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/power-of-four/
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        int idx=0;
        while(num>0) {
            if((num&1)>0 && (num>>1)>0) {
                return false;
            }
            num>>=1;
            idx++;
        }
        return idx%2==1;
    }
}
