/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/h-index-ii/
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 *
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length-1;
        
        if(end<0 || citations[end]<1) {
            return 0;
        }
        
        while(start < end) {
            int mid = start + (end-start)/2;
            int h = citations.length-mid;
            if(citations[mid] >= h) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        
        return citations.length-end;
    }
}
