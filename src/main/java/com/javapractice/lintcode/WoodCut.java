/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/wood-cut/
 * Given n pieces of wood with length L[i] (integer array). 
 * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
 * What is the longest length you can get from the n pieces of wood? Given L & k, 
 * return the maximum length of the small pieces.
 * For L=[232, 124, 456], k=7, return 114.
 * You couldn't cut wood into float length.
 * O(n log Len), where Len is the longest length of the wood.
 *
 */
public class WoodCut {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int len = L.length;
        if(len == 0) {
            return 0;
        }
        
        int max = L[0];
        for(int i=1; i<len; i++) {
        	max = (L[i] > max)?L[i]:max;
        }

        int start = 0;
        int end = max;
        while(start < end-1) {
        	int mid = start + (end-start)/2;
        	int sum = 0;
        	for(int i=0; i<len; i++) {
        		sum += (int)Math.floor(L[i]/mid);
        	}
        	if(sum >= k) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        return start;
    }
}
