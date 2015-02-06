/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        int len = A.length;
		if(len <= 0) {
			return 1;
		}
		
		boolean[] ret = new boolean[len+1];
		for(int i=0; i<len; i++) {
			int cur = A[i];
			if(cur > len || cur <= 0) {
				continue;
			}
			if(cur > 0) {
				ret[cur] = true;
			}
		}
		
		for(int i=1; i<len+1; i++) {
			if(!ret[i]) {
				return i;
			}
		}
		
		return len+1;
    }
	
	public int firstMissingPositiveBetter(int[] A) {
        int len = A.length;
		if(len <= 0) {
			return 1;
		}
		
		for(int i=0; i<len; i++) {
			int cur = A[i];
			if(cur > len || cur <= 0 || cur == i+1 || A[cur-1] == cur) {
				continue;
			}
			if(cur > 0) {
				A[i] = A[cur-1];
				A[cur-1] = cur;
			}
		}
		
		for(int i=1; i<len+1; i++) {
			if(A[i-1] != i) {
				return i;
			}
		}
		
		return len+1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
