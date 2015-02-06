/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if(A == null) {
            return false;
        }
        if(A.length == 1) {
            return true;
        }
        
        int nextIndex = A[0];
        
        while(nextIndex > 0) {
            if(nextIndex >= A.length - 1) {
                return true;
            }
            if(A[nextIndex] == 0) {
                int temp = nextIndex;
                do {
                    nextIndex--;
                } while(nextIndex+A[nextIndex] <= temp && nextIndex > 0);
            } else {
                nextIndex += A[nextIndex];
            }
        }
        
        return false;
    }
    
    public boolean canJumpAlternate(int[] A) {
        if(A == null) {
            return false;
        }
        int last = A.length - 1;
        for(int i=A.length-2; i>=0; i--) {
            if(A[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
    
    public boolean canJumpFaster(int[] A) {
        if(A == null) {
            return false;
        }
        if(A.length == 1) {
            return true;
        }
        if(A[0] == 0) {
            return false;
        }
        
        for(int i=1; i<A.length; i++) {
            A[i] = Math.max(A[i-1], A[i]+i);
            if(A[i] >= A.length - 1) {
                return true;
            }
            if(A[i] <= i) {
                return false;
            }
        }
        
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
