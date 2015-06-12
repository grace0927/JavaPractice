/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/o1-check-power-of-2/
 * Using O(1) time to check whether an integer n is a power of 2.
 * For n=4, return true;
 * For n=5, return false;
 * O(1) time
 *
 */
public class CheckPowerOfTwo {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        return n>0 && (n&(n-1))==0;
    }
}
