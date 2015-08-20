/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/shortest-palindrome/
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 *
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        char[] set = s.toCharArray();
        int start = 0;
        int end = set.length-1;
        int from = end;
        boolean palindrome = false;
        while(start < end) {
            if(set[start] == set[end]) {
                start++;
                end--;
                palindrome = true;
            } else {
                if(palindrome) {
                    start = 0;
                    palindrome = false;
                }
                from--;
                end = from;
            }
        }
        
        StringBuilder str = new StringBuilder(s);
        for(int i=from+1; i<set.length; i++) {
            str.insert(0, set[i]);
        }
        return str.toString();
    }
}
