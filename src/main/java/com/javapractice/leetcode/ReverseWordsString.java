/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Clarification:
 * What constitutes a word?
 *     A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 *     Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 *     Reduce them to a single space in the reversed string.
 *     
 */
public class ReverseWordsString {
    public String reverseWords(String s) {
        class CharStack {
        	private int current = -1;
        	char[] stack;

        	CharStack(int size) {
        		stack = new char[size];
        	}
        	
        	public void push(char a) {
        		current++;
        		stack[current] = a;
        	}
        	
        	public char pop() {
        		char tmp = stack[current];
        		current--;
        		return tmp;
        	}
        	
        	public boolean isEmpty() {
        		return (current == -1);
        	}
        }
        
        int length = s.length();
        int index;
        int rIndex = 0;
        char[] res = new char[length];
        CharStack filo = new CharStack(length);
        
        for(index=length-1; index>=0; index--) {
        	char tmp = s.charAt(index);
        	if(tmp!=32) {
        		filo.push(tmp);
        	} else {
        		while(!filo.isEmpty()) {
        			res[rIndex] = filo.pop();
        			rIndex++;
        		}
        		if(rIndex > 0 && res[rIndex-1] != 32) {
        			res[rIndex] = 32;
        			rIndex++;
        		}
        	}
        }
        
        while(!filo.isEmpty()) {
        	res[rIndex] = filo.pop();
        	rIndex++;
        }
        
        if(rIndex > 0) {
        	while(res[rIndex-1]==32) {
        		res[rIndex-1] = 0;
        		rIndex--;
        	}
        }
        
        if(rIndex == length) {
        	String resString = new String(res);
        	return resString;
        } else if(rIndex == 0){
        	return "";
        } else {
        	char[] trimRes = new char[rIndex];
        	for(int i=0; i<rIndex; i++) {
        		trimRes[i] = res[i];
        	}
        	String resString = new String(trimRes);
        	return resString;
        }
    }
}
