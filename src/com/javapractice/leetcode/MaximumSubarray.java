package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/maximum-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [�?2,1,�?3,4,�?1,2,1,�?5,4],
 * the contiguous subarray [4,�?1,2,1] has the largest sum = 6.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 */

public class MaximumSubarray {

	public int maxSubArray(int[] A) {
        int result = 0;
        int current = 0;
        boolean positive = false;
        for(int i=0; i<A.length; i++) {
            if(i==0 && A[0]<0) result = A[0];
            if(!positive) {
                if(A[i]<0) {
                    current = A[i];
                    result = Math.max(current, result);
                    continue;
                } else {
                    positive = true;
                    current = 0; 
                }
            }
            current += A[i];
            if(current < 0) current = 0;
        	result = Math.max(current, result);
        }
        return result;
    }
	
	public int maxSubArrayDC(int[] A) {
		int size = A.length;
        int left = A.length/2;
        int right = left+1;
        
        if(size == 1) {
        	return A[0];
        } else if(size == 2) {
        	return Math.max(A[0], A[1]);
        } else {
        	int[] leftA = new int[left];
        	int[] rightA = new int[size-left];
        	for(int i=0; i<size; i++) {
        		if(i<left) {
        			leftA[i] = A[i];
        		} else {
        			rightA[i-left] = A[i];
        		}
        	}
        	int leftMax = maxSubArrayDC(leftA);
        	int rightMax = maxSubArrayDC(rightA);
        	int leftSum = 0;
        	int sum = 0;
        	for(int i=left; i>=0; i--) {
        		sum += A[i];
        		if(sum > leftSum) {
        			leftSum = sum;
        		}
        	}
        	int rightSum = 0;
        	sum = 0;
        	for(int i=right; i<size; i++) {
        		sum += A[i];
        		if(sum > rightSum) {
        			rightSum = sum;
        		}
        	}
        	int midMax = leftSum + rightSum;
        	return Math.max(Math.max(leftMax, rightMax), midMax);
        }
    }

}
