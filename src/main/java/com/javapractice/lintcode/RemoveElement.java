/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/remove-element/
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,0,0,2]
 *
 */
public class RemoveElement {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int start = 0;
        int end = A.length-1;
        if(end < 0) {
            return 0;
        }
        
        while(start < end) {
            if(A[start] == elem) {
                int temp = A[end];
                A[end] = A[start];
                A[start] = temp;
                end--;
            } else {
                start++;
            }
        }
        
        return (A[start]==elem)?start:start+1;
    }
}
