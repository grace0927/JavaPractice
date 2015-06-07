/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional 
 * initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace 
 * characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN 
 * (-2147483648) is returned.
 *
 */
public class StringToIntegerAtoi {
	public int atoi(String str) {
        if(str == null || str.length()<1) {
            return 0;
        }
        int len = str.length();
		boolean neg = false;
		boolean space = true;
		boolean sign = true;
		
		long res = 0;
		for(int i=0; i<len; i++) {
		    if(str.charAt(i)>=48 && str.charAt(i)<58) {
		        space = false;
			    res = res*10+str.charAt(i)-48;
		    } else {
		        if(space && str.charAt(i)==32) {
		            continue;
		        } else if(sign && str.charAt(i)=='-') {
		            neg = true;
		            space = false;
		            sign = false;
		            continue;
		        } else if(sign && str.charAt(i)=='+') {
		            neg = false;
		            space = false;
		            sign = false;
		            continue;
		        } else {
		            if(neg) {
		                res = -res;
		            }
		            return (int)res;
		        }
		    }
		    
			if(neg && -res < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			if((!neg) && res > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
		}
		
		if(neg) {
			res = -res;
		}
		return (int)res;
    }
}
