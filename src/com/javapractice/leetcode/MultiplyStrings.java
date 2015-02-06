/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/multiply-strings/
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 */
public class MultiplyStrings {	
	public String multiply(String num1, String num2) {
        int len1 = num1.length();
		int len2 = num2.length();
		
		if((len1 == 1 && num1.charAt(0) == '0') || (len2 == 1 && num2.charAt(0) == '0')) {
		    return "0";
		}
		
		if(len2 == 1) {
			StringBuilder result = new StringBuilder();
			int add = 0;
			int two = num2.charAt(0)-48;
			for(int i=len1-1; i>=0; i--) {
				int one = num1.charAt(i)-48;
				int ret = one*two+add;
				char cur = (char)(ret%10+48);
				result.insert(0, cur);
				add = ret/10;
			}
			if(add > 0) {
				result.insert(0, (char)(add+48));
			}
			return result.toString();
		} else {
			StringBuilder result = new StringBuilder();
			String second = multiply(num1, num2.substring(1, len2));
			int add = 0;
			int two = num2.charAt(0)-48;
			for(int i=len1-1; i>=0; i--) {
				int one = num1.charAt(i)-48;
				int ret = one*two+add;
				char cur = (char)(ret%10+48);
				result.insert(0, cur);
				add = ret/10;
			}
			if(add > 0) {
				result.insert(0, (char)(add+48));
			}
			for(int i=1; i<len2; i++) {
				result.append('0');
			}
			String first = result.toString();
			return addUtil(first, second);
		}
	}
	
	public String addUtil(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int len = (len1>len2)?len2:len1;
		StringBuilder result = new StringBuilder();
		int add = 0;
		
		for(int i=0; i<len; i++) {
			int one = num1.charAt(len1-i-1)-48;
			int two = num2.charAt(len2-i-1)-48;
			int cur = one+two+add;
			
			result.insert(0, (char)(cur%10+48));
			add = cur/10;
		}
		if(len1 > len2) {
			for(int i=0; i<len1-len; i++) {
				int one = num1.charAt(len1-1-len-i)-48;
				int cur = one+add;
				
				result.insert(0, (char)(cur%10+48));
				add = cur/10;
			}
		} else {
			for(int i=0; i<len2-len; i++) {
				int one = num2.charAt(len1-1-len-i)-48;
				int cur = one+add;
				
				result.insert(0, (char)(cur%10+48));
				add = cur/10;
			}
		}
		if(add != 0) {
			result.insert(0, (char)(add+48));
		}
		
		return result.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiplyStrings test = new MultiplyStrings();
		System.out.println(test.multiply("0", "52"));
	}

}
