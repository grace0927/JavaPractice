/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/sum-of-two-integers/
 * Calculate the sum of two integers a and b, 
 * but you are not allowed to use the operator + and -.
 *
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int res=0, over=0;
        for(int i=0; i<32; i++) {
            int ai=((a>>i)&1), bi=((b>>i)&1);
            if(ai==1 && bi==1) {
                if(over==1) {
                    res += (1<<i);
                }
                over = 1;
            } else if(ai==1 || bi==1) {
                if(over!=1) {
                    res += (1<<i);
                }
            } else if(over==1) {
                res += (1<<i);
                over = 0;
            }
        }
        return res;
    }
}
