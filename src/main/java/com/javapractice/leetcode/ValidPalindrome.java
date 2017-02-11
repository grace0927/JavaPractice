/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/valid-palindrome/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null) {
            return true;
        }
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur >= 'a' && cur <= 'z') {
                ret.append(cur);
            }
            if(cur >= 'A' && cur <= 'Z') {
                ret.append((char)(cur+32));
            }
            if(cur >= '0' && cur <= '9') {
                ret.append(cur);
            }
        }
        
        return isPalindromeUtil(ret.toString());
    }
    
    public boolean isPalindromeUtil(String s) {
        if(s.length() < 2) {
            return true;
        }
        int start = 0; 
        int end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
