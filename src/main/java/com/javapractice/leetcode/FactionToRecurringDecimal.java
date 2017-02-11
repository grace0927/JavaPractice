/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 */
public class FactionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder str = new StringBuilder();
        long base = (long)numerator/denominator;
		str.append(base);
		str.append('.');
		long remain = (long)numerator%denominator;
		HashMap<Long, Integer> map = new HashMap<>();
		if(base < 0) {
		    remain *= -1;
		}
		boolean neg = false;
		
		while(remain != 0) {
			remain *= 10;
			if(map.containsKey(remain)) {
				str.insert((int)map.get(remain), '(');
				str.append(')');
				if(neg) {
				    str.insert(0, '-');
				}
				return  str.toString();
			}
			map.put(remain, str.length());
			base = (long)remain/denominator;
			if(base < 0) {
			    remain *= -1;
			    base *= -1;
			    neg = true;
			}
			str.append(base);
			remain %= (long)denominator;
		}
		
		if(str.charAt(str.length()-1) == '.') {
		    str.deleteCharAt(str.length()-1);
		}
		if(neg) {
		    str.insert(0, '-');
		}
		return str.toString();
    }
}
