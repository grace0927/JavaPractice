/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/first-missing-positive/
 * Given an unsorted integer array, find the first missing positive integer.
 * Example
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Challenge
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class FirstMissingPositive {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        int len = A.length;
        for(int i=0; i<len; i++) {
            int cur = A[i];
            if(cur>len || cur<=0 || cur-1==i || cur==A[cur-1]) {
                continue;
            } else {
                A[i] = A[cur-1];
                A[cur-1] = cur;
                i--;
            }
        }
        for(int i=0; i<len; i++) {
            if(A[i] != i+1) {
                return i+1;
            }
        }
        return len+1;
    }
}
