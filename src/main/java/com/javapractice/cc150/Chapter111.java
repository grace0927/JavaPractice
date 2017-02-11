/**
 * 
 */
package com.javapractice.cc150;

/**
 * @author feng
 *
 */
public class Chapter111 {
	public int[] merge(int[] A, int[] B) {
		int lenA = A.length;
		int lenB = B.length;
		int endA = 0;
		int endB = lenB-1;

		while(A[endA]!=0) {
			endA++;
		}

		while(endA>=0 && endB>=0) {
			if(A[endA] >= B[endB]) {
				A[lenA-1] = A[--endA];
			} else {
				A[lenA-1] = B[--endB];
			}
			lenA--;
		}
		while(endA>=0) {
			A[lenA-1] = A[--endA];
			lenA--;
		}
		while(endB>=0) {
			A[lenA-1] = B[--endB];
			lenB--;
		}
		
		return A;
	}

}
