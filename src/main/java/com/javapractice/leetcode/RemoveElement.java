/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/remove-element/
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        if(A == null) {
        	// Special Case 1: Null Array
            return 0;
        } else if(A.length == 0) {
        	// Special Case 2: Empty Array
            return 0;
        } else {
        	// Common Case
            int size = A.length;
            int iStart = 0;
            int iEnd = size - 1;
            
            // Switch first element with given value with the last element with non-given value
            while(iStart < iEnd) {
            	// find the last element with non-given value
                while(iEnd >= 0 && A[iEnd] == elem) {
                    iEnd --;
                    if(iEnd < 0) {
                        return 0;
                    }
                }
                
                // special case handling
                if(iEnd <= iStart) {
                    break;
                }
                if(iEnd == 0) {
                    return 1;
                }
                
                // find the first element with given value
                if(A[iStart] == elem) {
                    A[iStart] = A[iEnd];
                    A[iEnd] = elem;
                    iEnd--;
                }
                iStart++;
            }
            
            // Boundary Handling
            if(iStart > iEnd) {
                return iEnd+1;
            } else {
                if(A[iStart] == elem) {
                    return iStart;
                } else {
                    return iStart+1;
                }
            }
        }
    }
	
	/* 
	 * referred from https://oj.leetcode.com/discuss/16360/9-line-java-solution
	 * switch element with given value with the last element of modified array
	 * 
	 */
	public int removeElementOther(int[] A, int elem) {
	    int len = A.length;
	    for (int i = 0 ; i< len; ++i){
	        while (A[i]==elem && i< len) {
	            A[i]=A[--len];
	        }
	    }
	    return len;
	}
}
