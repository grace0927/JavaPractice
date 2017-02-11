/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/power-of-three/
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        while(n%3==0 && n>1) {
            n /= 3;
        }
        return n==1;
    }
    
}
