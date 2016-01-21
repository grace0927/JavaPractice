/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Feng
 * https://leetcode.com/problems/remove-duplicate-letters/
 * Given a string which contains only lowercase letters, 
 * remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order 
 * among all possible results.
 * Example:
 * Given "bcabc"
 * Return "abc"
 * 
 * Given "cbacdcbc"
 * Return "acdb"
 * ref: https://www.hrwhisper.me/leetcode-remove-duplicate-letters/
 *
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] cnt = new int[26];
        
        for(int i=0; i<len; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if(set.contains(cur)) {
                cnt[cur-'a']--;
            } else {
                while(!stack.isEmpty() && cur<stack.peek() && cnt[stack.peek()-'a']>0) {
                    set.remove(stack.peek());
                    stack.pop();
                }
                stack.push(cur);
                set.add(cur);
                cnt[cur-'a']--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}
