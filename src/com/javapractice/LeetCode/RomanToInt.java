package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/roman-to-integer/ 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 */

public class RomanToInt {
	public int romanToInt(String s) {
		int key = 1;
		int level = 1;
		int res = 0;
		int length = s.length();
		for(int index = length-1; index >= 0; index--) {
			char last = s.charAt(index);
			switch (last) {
				case 'I':
					level = 1;
					if(level >= key) {
						res += 1;
						key = level;
					} else {
						res -= 1;
					}
					break;
				case 'V':
					level = 5;
					if(level >= key) {
						res += 5;
						key = level;
					} else {
						res -= 5;
					}
					break;
				case 'X':
					level = 10;
					if(level >= key) {
						res += 10;
						key = level;
					} else {
						res -= 10;
					}
					break;
				case 'L':
					level = 50;
					if(level >= key) {
						res +=50;
						key = level;
					} else {
						res -= 50;
					}
					break;
				case 'C':
					level = 100;
					if(level >= key) {
						res += 100;
						key = level;
					} else {
						res -= 100;
					}
					break;
				case 'D':
					level = 500;
					if(level >= key) {
						res += 500;
						key = level;
					} else {
						res -= 500;
					}
					break;
				case 'M':
					level = 1000;
					if(level >= key) {
						res += 1000;
						key = level;
					} else {
						res -= 1000;
					}
					break;
			}
		}
		
		return res;
    }
}
