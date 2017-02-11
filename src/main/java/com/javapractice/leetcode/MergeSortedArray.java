/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. The number of elements initialized in A and B are m
 * and n respectively.
 *
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m];
        for(int i=0; i<m; i++) {
            temp[i] = A[i];
        }
		int indexA = 0;
		int indexB = 0;
		while(indexA < m && indexB < n) {
			if(temp[indexA] > B[indexB]) {
				A[indexA+indexB] = B[indexB];
				indexB++;
			} else {
				A[indexA+indexB] = temp[indexA];
				indexA++;
			}
		}
		if(indexA == m) {
			while(indexB < n) {
				A[indexA+indexB] = B[indexB];
				indexB++;	
			}
		}
		if(indexB == n) {
			while(indexA < m) {
				A[indexA+indexB] = temp[indexA];
				indexA++;	
			}
		}
    }
    
    public void mergeInPlace(int A[], int m, int B[], int n) {
        int indexA = m-1;
        int indexB = n-1;
        int indexM = m+n-1;
        
        while(indexM >= 0 && indexB >= 0 && indexA >= 0) {
            if(A[indexA] > B[indexB]) {
                A[indexM] = A[indexA];
                indexM--;
                indexA--;
            } else {
                A[indexM] = B[indexB];
                indexM--;
                indexB--;
            }
        }
        if(indexA == -1 && indexB != -1) {
            while(indexB >= 0) {
                A[indexB] = B[indexB];
                indexB--;
            }
        }
    }
}
