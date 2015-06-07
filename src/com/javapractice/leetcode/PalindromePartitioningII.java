/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
public class PalindromePartitioningII {
	/*
	 * ref: http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
	 */
	public int minCut(String s) {
        int len = s.length();
		if(len <= 1) {
			return 0;
		}
		
		boolean[][] ret = new boolean[len][len];
		int[] min = new int[len];
		for(int i=0; i<len; i++) {
			ret[i][i] = true;
			min[i] = i;
		}
		
		for(int j=1; j<len; j++) {
			for(int i=0; i<len-j; i++) {
				if((j<2||ret[i+1][i+j-1]) && s.charAt(i)==s.charAt(i+j)) {
					ret[i][i+j] = true;
				}
			}
		}
		
		for(int i=0; i<len; i++) {
			if(ret[0][i]) {
				min[i] = 0;
			} else {
				for(int j=0; j<i; j++) {
					if(ret[j+1][i]) {
						min[i] = Math.min(min[i], min[j]+1);
					}
				}
			}
		}
		
		return min[len-1];
    }
	
	public boolean isPalindrome(String s, int start, int end) {
		while(start < end) {
			if(s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
    }
	
	public int minCutDP(String s) {
        int len = s.length();
		if(len <= 1) {
			return 0;
		}
		
		int[][] ret = new int[len][len];
		for(int i=0; i<len; i++) {
			ret[i][0] = 0;
		}
		
		for(int j=0; j<len; j++) {
			for(int i=0; i<len-j; i++) {
				if((j<2 || ret[i+1][j-2]==0) && s.charAt(i) == s.charAt(i+j)) {
					ret[i][j] = 0;
				} else {
					ret[i][j] = ret[i][0]+ret[i+1][j-1]+1;
					for(int k=1; k<j; k++) {
						ret[i][j] = Math.min(ret[i][j], ret[i][k]+ret[i+k+1][j-k-1]+1);
					}
				}
			}
		}
		return ret[0][len-1];
    }

}
