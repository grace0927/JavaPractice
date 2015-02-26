/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/word-break-ii/
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		
		int len = s.length();
		boolean[][] ret = new boolean[len][len];
		for(int i=0; i<len; i++) {
            if(dict.contains(s.substring(i,i+1))) {
                ret[i][i] = true;
            } else {
                ret[i][i] = false;
            }
        }
        
        for(int i=1; i<len; i++) {
            for(int j=i-1; j>=0; j--) {
                ret[j][i] = dict.contains(s.substring(j, i+1));
                if(ret[j][i] == false) {
                    for(int k=j; k<i; k++) {
                        ret[j][i] = ret[j][k] && ret[k+1][i];
                        if(ret[j][i] == true) {
                            break;
                        }
                    }
                }
            }
        }
		
		if(ret[0][len-1]) {
			wordBreakUtil(list, s, dict, 0, str, ret);
		}
		
		return list;
    }
	
	public void wordBreakUtil(List<String> list, String s, Set<String> dict, int start, StringBuilder str, boolean[][] ret) {
		if(start == s.length()) {
		    str.deleteCharAt(str.length()-1);
			list.add(str.toString());
			return ;
		}
		for(int i=start; i<s.length(); i++) {
			if(ret[start][i]) {
				String cur = s.substring(start, i+1);
				if(dict.contains(cur)) {
					str.append(cur);
					str.append(" ");
					wordBreakUtil(list, s, dict, i+1, str, ret);
					str.delete(str.lastIndexOf(cur), str.length());
				}
			}
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
