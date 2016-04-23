/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author feng
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>(
        		Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u','A','E','I','O','U'}));
        char[] arr = s.toCharArray();
        int start=0, end=arr.length-1;
        while(start<end) {
            while(start<end && !set.contains(arr[start])) {
                start++;
            }
            while(start<end && !set.contains(arr[end])) {
                end--;
            }
            if(start<end) {
                char c = arr[start];
                arr[start] = arr[end];
                arr[end] = c;
            }
            start++;
            end--;
        }
        return new String(arr);
    }
}
