/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 */
public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int len = A.length;
        for(int i=len-1; i>=0; i--) {
            if(A[i]+i >= len-1) {
                A[i] = len-1;
            } else {
                for(int j=A[i]; j>=0; j--) {
                    A[i] = (A[i]+j > A[i+j])?A[i]+j:A[i+j];
                }
            }
        }
        return A[0] >= len-1;
    }
}
