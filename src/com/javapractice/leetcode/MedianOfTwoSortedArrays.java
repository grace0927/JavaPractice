/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 * http://ocw.alfaisal.edu/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
		int lenB = B.length;
		
		if((lenA+lenB)%2 != 0) {
			return (double)findMedian(A, B, (lenA+lenB)/2, 0, lenA-1, 0, lenB-1);
		} else {
			return (findMedian(A, B, (lenA+lenB)/2, 0, lenA-1, 0, lenB-1)+findMedian(A, B, (lenA+lenB)/2-1, 0, lenA-1, 0, lenB-1))*0.5;
		}
    }
	
	public int findMedian(int A[], int B[], int median, int startA, int endA, int startB, int endB) {
		int lenA = endA-startA+1;
		int lenB = endB-startB+1;
		
		if(lenA == 0) {
			return B[startB+median];
		}
		if(lenB == 0) {
			return A[startA+median];
		}
		if(median == 0) {
			return A[startA]<B[startB]?A[startA]:B[startB];
		}
		
		int midA = lenA*median/(lenA+lenB);
		int midB = median-midA-1;
		
		midA = midA+startA;
		midB = midB+startB;
		
		if(A[midA] > B[midB]) {
			median -= (midB-startB+1);
			endA = midA;
			startB = midB+1;
		} else {
			median -= (midA-startA+1);
			endB = midB;
			startA = midA+1;
		}
		
		return findMedian(A, B, median, startA, endA, startB, endB);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
