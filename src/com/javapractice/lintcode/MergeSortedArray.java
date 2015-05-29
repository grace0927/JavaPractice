/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/merge-sorted-array/
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 *
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        for(int i=m-1,j=n-1,k=m+n-1; k>=0; k--) {
            if(i<0) {
                A[k] = B[j--];
                continue;
            }
            
            if(j<0) {
                A[k] = A[i--];
                continue;
            }
            
        	if(A[i] > B[j]) {
        		A[k] = A[i--];
        	} else {
        		A[k] = B[j--];
        	}
        }
    }
}
