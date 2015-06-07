/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/interleaving-string/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class InterleavingString {
	
	/*
	 * slow using recursive method
	 */
	public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if(s1.length()==0 && s2.length()==0 && s3.length()==0) {
			return true;
		}
		if(s1.length()==0) {
			if(s3.equals(s2)) {
				return true;
			} else {
				return false;
			}
		}
		if(s2.length()==0) {
			if(s3.equals(s1)) {
				return true;
			} else {
				return false;
			}
		}
		if(s3.length()==0) {
			return false;
		}
		
		char a = s1.charAt(0);
		char b = s2.charAt(0);
		char c = s3.charAt(0);
		
		if(a==b) {
			if(c==a) {
				return (isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1)));
			} else {
				return false;
			}
		} else {
			if(c==a) {
				return isInterleave(s1.substring(1), s2, s3.substring(1));
			} else if(c==b) {
				return isInterleave(s1, s2.substring(1), s3.substring(1));
			} else {
				return false;
			}
		}
    }
	
	/*
	 * dynamic programming method
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
        int lenA = s1.length();
		int lenB = s2.length();
		int lenC = s3.length();
		
		if(lenC != lenA+lenB) {
			return false;
		}
		if(lenC == 0) {
			return true;
		}
		if(lenA == 0) {
		    return s3.equals(s2);
		}
		if(lenB == 0) {
		    return s3.equals(s1);
		}
		
		boolean[][] arr = new boolean[lenA+1][lenB+1];
		
		arr[0][0] = true;
		for(int i=1; i<=lenA; i++) {
			arr[i][0] = s3.substring(0, i).equals(s1.substring(0, i));
		}
		for(int i=1; i<=lenB; i++) {
			arr[0][i] = s3.substring(0, i).equals(s2.substring(0, i));
		}
		
		for(int i=1; i<=lenA; i++) {
			for(int j=1; j<=lenB; j++) {
				arr[i][j] = ((s1.charAt(i-1)==s3.charAt(i+j-1)&&arr[i-1][j])||(s2.charAt(j-1)==s3.charAt(i+j-1)&&arr[i][j-1]));
			}
		}
		
		return arr[lenA][lenB];
    }
}
