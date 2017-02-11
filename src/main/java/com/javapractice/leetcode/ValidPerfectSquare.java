/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/valid-perfect-square/
 * Given a positive integer num, 
 * write a function which returns True if num is a perfect square else False.
 *
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num==1 || num==4) {
            return true;
        }
        int s=0, e=num/2;
        while(s<e-1) {
            int mid=s+(e-s)/2, tmp=num/mid;
            if(tmp>=mid) {
                s = mid;
            } else {
                e = mid;
            }
        }
        return s*s==num || e*e==num;
    }
}
