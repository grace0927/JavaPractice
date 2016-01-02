/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;

/**
 * @author feng
 * https://leetcode.com/problems/h-index/
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "
 * A scientist has index h if h of his/her N papers have at least h citations each, 
 * For example, given citations = [3, 0, 6, 1, 5], 
 * which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 
 * citations respectively. Since the researcher has 3 papers with at least 3 citations each and 
 * the remaining two with no more than 3 citations each, his h-index is 3.and the other N − h 
 * papers have no more than h citations each."
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i=0; i<n; i++) {
        	int h = n-i;
            if(citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
    
    /*
     * use extra space to reduce time
     */
    public int hIndexAlter(int[] citations) {
        int n = citations.length;
        int[] res = new int[n+1];
        for(int i=0; i<n; i++) {
            if(citations[i]>=n) {
                res[n]++;
            } else {
                res[citations[i]]++;
            }
        }
        
        int h = 0;
        for(int i=n; i>=0; i--) {
            h += res[i];
            if(h >= i) {
                return i;
            }
        }
        return 0;
    }
}
