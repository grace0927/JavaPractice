/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        char[] ret = new char[n];
        for(int i=0; i<n; i++) {
            ret[i] = (char)(i+'1');
        }
        for(int i=1; i<k; i++) {
            ret = getNext(ret);
        }
        return new String(ret);
    }
    
    public char[] getNext(char[] ret) {
    	int len = ret.length;
		int pivot = len - 1;
		
		// find pivot index
		for(int i=len-2; i>=0; i--) {
			if(ret[i] < ret[i+1]) {
				pivot = i;
				break;
			}
		}
		
		if(pivot == len-1) {
			// special case: descending order
			int start = 0;
			int end = len-1;
			while(start < end) {
			    char temp = ret[start];
			    ret[start] = ret[end];
			    ret[end] = temp;
			    start++;
			    end--;
		    }
		} else {
			int change = len-1;
			char pivotValue = ret[pivot];
			
			for(int i=len-1; i>pivot; i--) {
				if(ret[i] > pivotValue) {
					change = i;
					break;
				}
			}
			
			ret[pivot] = ret[change];
			ret[change] = pivotValue;
			
			int start = pivot+1;
			int end = len-1;
			while(start < end) {
			    char temp = ret[start];
			    ret[start] = ret[end];
			    ret[end] = temp;
			    start++;
			    end--;
		    }
		}
		
        return ret;
    }
    
    // ref: http://www.cnblogs.com/tenosdoit/p/3721918.html
    public String getPermutationMath(int n, int k) {
        char[] ret = new char[n];
        int total = 1;
        for(int i=2; i<n+1; i++) {
            total *= i;
        }
        StringBuilder candidate = new StringBuilder("123456789".substring(0, n));
        for(int i=0; i<n; i++) {
            total /= (n-i);
            int index = (k-1)/total;
            ret[i] = candidate.charAt(index);
            candidate.deleteCharAt(index);
            k -= index*total;
        }
        
        return new String(ret);
    }
}
