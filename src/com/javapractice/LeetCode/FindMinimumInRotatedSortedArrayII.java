/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 *
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        // special case: array with no element
        if(num == null) {
            return 0;
        }
        // special case: array with one element
        if(num.length == 1) {
            return num[0];
        } 
        
        int start = 0;
        int end = num.length-1;
        
        while(end > start) {
            if(end == start+1) {
                break;
            }
            
            if(num[start] < num[end]) {
                return num[start];
            }
            if(num[end] < num[end-1]) {
                return num[end];
            }
            
            int mid = (end+start)/2;
            if(num[mid] < num[mid-1]) {
                return num[mid];
            }
            if(num[mid] > num[start]) {
                start = mid;
            } else if(num[mid] < num[start]) {
                end = mid;
            } else {
                if(num[mid] > num[end]) {
                    start = mid;
                } else if(num[mid] < num[end]) {
                    end = mid;
                } else {
                    start++;
                    end--;
                }
            }
        }
        
        return num[start]<num[end]?num[start]:num[end];        
    }
    
    public int findMinNative(int[] num) {
        // special case: array with no element
        if(num == null) {
            return 0;
        }
        // special case: array with one element
        if(num.length == 1) {
            return num[0];
        } 
        
        for(int i=1; i<num.length; i++) {
            if(num[i] < num[i-1]) {
                return num[i];
            }
        }
        
        return num[0];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
