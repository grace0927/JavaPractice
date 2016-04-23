/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/reverse-string/
 * Write a function that takes a string as input and returns the string reversed.
 *
 */
public class ReverseString {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }
}
