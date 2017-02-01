/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * You may assume that all words are consist of lowercase letters a-z.
 *
 */
public class AddAndSearchWordDataStructureDesign {
	private Node root = new Node('#');

	// Adds a word into the data structure.
	public void addWord(String word) {
		Node pnt = root;
		for(int i=0; i<word.length(); i++) {
			char cur = word.charAt(i);
			if(!pnt.map.containsKey(cur)) {
				Node node = new Node(cur);
				pnt.map.put(cur, node);
				pnt = node;
			} else {
				pnt = pnt.map.get(cur);
			}
		}
		if(!pnt.map.containsKey('#')) {
			pnt.map.put('#', new Node('#'));
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return searchUtil(root, word);
	}
	
	public boolean searchUtil(Node root, String word) {
		if(word.length()==0) {
			if(root.map.containsKey('#')) {
				return true;
			} else {
				return false;
			}
		}
		char cur = word.charAt(0);
		if(cur != '.') {
			if(root.map.containsKey(cur)) {
				return searchUtil(root.map.get(cur), word.substring(1));
			} else {
				return false;
			}
		} else {
			for(Character node : root.map.keySet()) {
				if(searchUtil(root.map.get(node), word.substring(1))) {
					return true;
				}
			}
		}
		return false;
	}
	
	class Node {
		public char val;
		public HashMap<Character, Node> map;
		public Node(char val) {
			this.val = val;
			map = new HashMap<>();
		}
		
	}
}
