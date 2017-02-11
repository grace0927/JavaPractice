/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
		List<String> row = new ArrayList<>();
		partitionUtil(result, row, 0, s.length(), s);
		return result;
    }
	
	public void partitionUtil(List<List<String>> result, List<String> row, int start, int len, String s) {
		if(start == s.length()) {
			List<String> temp = new ArrayList<>(row);
			result.add(temp);
			return ;
		}
		for(int i=1; i<len+1; i++) {
			String cur = s.substring(start, start+i);
			if(isPalindrome(cur.toCharArray())) {
				row.add(cur);
				partitionUtil(result, row, start+i, len-i, s);
				row.remove(row.size()-1);
			}
		}
		return ;
	}
	
	public boolean isPalindrome(char[] s) {
		int len = s.length;
		
		for(int i=0; i<len/2; i++) {
			if(s[i] != s[len-i-1]) {
				return false;
			}
		}
		
		return true;
    }

}
