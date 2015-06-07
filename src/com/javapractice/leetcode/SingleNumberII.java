package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/single-number-ii/
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 */

public class SingleNumberII {

	public int singleNumber(int[] A) {
        int size = A.length;
        int[] bin = new int[32];
        int result=0;
        
        for(int i=0; i<32; i++) {
        	for(int j=0; j<size; j++) {
        		bin[i] += (A[j]>>i & 1);
        	}
        	result |= ((bin[i]%3)<<i);
        }
        
        return result;
    }
	
}
