/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Set;

/**
 * @author feng
 * https://oj.leetcode.com/problems/word-break/
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
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
        
        return ret[0][len-1];
    }

}
