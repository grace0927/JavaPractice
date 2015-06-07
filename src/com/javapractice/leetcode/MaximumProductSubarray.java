/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class MaximumProductSubarray {
	public int maxProductMine(int[] A) {
        int len = A.length;
        int[][] ret = new int[len][len];
        int max = A[0];
        
        for(int i=0; i<len; i++) {
            ret[i][i] = A[i];
            if(A[i] > max) {
                max = A[i];
            }
        }
        
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                ret[i][j] = ret[i][j-1] * A[j];
                if(max < ret[i][j]) {
                    max = ret[i][j];
                }
            }
        }
        
        return max;
    }
	
	/*
	 * ref: https://oj.leetcode.com/discuss/14235/possibly-simplest-solution-with-o-n-time-complexity
	 */
	public int maxProduct(int[] A) {
        int len = A.length;
        int max = A[0];
        
        for(int i=1, imax=max, imin=max; i<len; i++) {
            if(A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(A[i], A[i] * imax);
            imin = Math.min(A[i], A[i] * imin);
            
            max = Math.max(imax, max);
        }
        
        return max;
    }
}
