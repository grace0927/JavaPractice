/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/decode-ways/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
        int len = s.length();
		if(len < 1) {
			return 0;
		}
		int[] ret = new int[len+1];
		ret[0] = 1;
		if(s.charAt(0) == 48) {
			return 0;
		}
		ret[1] = 1;
		
		for(int i=2; i<len+1; i++) {
			int one = s.charAt(i-1)-48;
			int two = Integer.parseInt(s.substring(i-2, i));
			if(one != 0) {
				ret[i] += ret[i-1];
			}
			if(two>=10 && two<27) {
				ret[i] += ret[i-2];
			}
			if(one==0 && two==0) {
				return 0;
			}
		}
		
		return ret[len];
    }

}
