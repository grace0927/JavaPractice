/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/valid-number/
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
        if(s==null || s.length()<1)
			return false;
		
		int len = s.length();
		int start = 0;
		int end = len-1;
		while(start<len && s.charAt(start)==' ') {
		    start++;
		}
		while(end>=0 && s.charAt(end)==' ') {
		    end--;
		}
		if(start==len) {
			return false;
		}
		if(start==end) {
			return (s.charAt(start)<='9'&&s.charAt(start)>='0');
		}
		
		if(s.charAt(start)=='-' || s.charAt(start)=='+') {
			start++;
		}
		
		boolean neg = true;
		boolean dot = false;
		boolean e = false;
		int sum = -1;
		for(int i=start; i<=end; i++) {
			char cur = s.charAt(i);
			if(cur == ' ') {
				return false;
			} else if(cur == '.') {
				if(dot) {
					return false;
				}
				dot = true;
			} else if(cur=='-' || cur=='+') {
			    if(i==start || i==end || neg) {
			        return false;
			    }
			    neg = true;
			}else if(cur == 'e') {
				if(i==start || i==end || e || sum==-1) {
					return false;
				}
				e = true;
				dot = true;
				neg = false;
			} else if(cur>='0' && cur<='9') {
				sum = cur-'0';
			} else {
				return false;
			}
		}
		
		return sum>-1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
