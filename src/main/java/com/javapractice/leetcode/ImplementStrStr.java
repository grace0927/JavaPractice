/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/implement-strstr/
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 */
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) {
            return -1;
        }
        for(int i=0; i<haystack.length()-needle.length()+1; i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
