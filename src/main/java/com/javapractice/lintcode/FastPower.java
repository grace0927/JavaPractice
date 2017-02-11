/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/fast-power/
 * Calculate the an % b where a, b and n are all 32bit integers.
 * For 231 % 3 = 2
 * For 1001000 % 1000 = 0
 * O(logn)
 * http://www.cnblogs.com/yuzhangcmu/p/4174781.html
 *
 */
public class FastPower {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(a==0) {
            return 0;
        }
        if(n==0) {
            return 1%b;
        }
        long res = 0;
        res = fastPower(a, b, n/2);
        res *= res;
        res %= b;
        
        if(n%2==1) {
            res *= (a%b);
        }
        res %= b;
        return (int)res;
    }
}
