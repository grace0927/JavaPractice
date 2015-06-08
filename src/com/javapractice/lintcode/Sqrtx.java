/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/sqrtx/
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * Example
 * sqrt(3) = 1
 * sqrt(4) = 2
 * sqrt(5) = 2
 * sqrt(10) = 3
 * O(log(x))
 *
 */
public class Sqrtx {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        int start = 1;
        while(start<=x/start) {
        	start *= 2;
        }
        int end = start;
        start /= 2;
        while(start < end-1) {
        	int mid = start + (end-start)/2;
        	if(mid==x/mid) {
        		return mid;
        	} else if(mid < x/mid) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        return start;
    }
}
