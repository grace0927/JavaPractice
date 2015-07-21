/**
 * 
 */
package com.javapractice.lintcode;

import java.util.HashSet;
import java.util.Set;



/**
 * @author jianyu
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLadderII test = new WordLadderII();
		Set<String> dict = new HashSet<>();
		String[] set = {"ts","sc","ph","ca","jr","hf","to","if","ha","is","io","cf","ta"};
		for(int i=0; i<set.length; i++) {
			dict.add(set[i]);
		}
		System.out.println(test.findLadders("ta", "if", dict));
	}

}
