/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author jianyu
 *
 */
public class TrieNode {
	public char val;
	public HashMap<Character, TrieNode> map;
	
    // Initialize your data structure here.
    public TrieNode() {
        this.val = '#';
		this.map = new HashMap<>();
    }
    
	public TrieNode(char val) {
        this.val = val;
		this.map = new HashMap<>();
    }
}
