/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Set;

/**
 * @author jianyu
 *
 */
public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
		int len = s.length();
		if(len == 0) {
			return true;
		}
		boolean[] res = new boolean[len];
		
		for(int i=0; i<len; i++) {
		    res[i] = dict.contains(s.substring(0, i+1));
			for(int j=0; !res[i] && j<=i; j++) {
				res[i] = (res[j] && dict.contains(s.substring(j+1, i+1)));
			}
		}
		
		return res[len-1];
    }
    
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     * ref: http://www.programcreek.com/2012/12/leetcode-solution-word-break/
     */
    public boolean wordBreakFast(String s, Set<String> dict) {
        // write your code here
		int len = s.length();
		boolean[] res = new boolean[len+1];
		res[0] = true;
		
		for(int i=0; i<len; i++) {
		    if(res[i]) {
		    	for(String str:dict) {
		    	    if(i+str.length()<=len && !res[i+str.length()]) {
		    		    res[i+str.length()] = (str.equals(s.substring(i, i+str.length())));
		    	    }
		    	}
		    }
		}
		
		return res[len];
    }
}
