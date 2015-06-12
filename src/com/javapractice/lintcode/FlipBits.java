/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/flip-bits/
 * Determine the number of bits required to flip if you want to convert integer n to integer m.
 * Given n = 31 (11111), m = 14 (01110), return 2.
 * Both n and m are 32-bit integers.
 *
 */
public class FlipBits {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int res=0;
        for(int i=0; i<32; i++) {
            if((a&1) != (b&1)) {
                res++;
            }
            a = (a>>1);
            b = (b>>1);
        }
        return res;
    }
    
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequiredBetter(int a, int b) {
        int res = 0;
        for (int c=a^b; c!=0; c&=(c-1)) {
            res++;
        }
        return res;
    }
}

