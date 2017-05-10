/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 */
public class ImplementTriePrefixTree {
	private TrieNode root;

	public ImplementTriePrefixTree() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode pnt = root;
		for(int i=0; i<word.length(); i++) {
			Character cur = word.charAt(i);
			if(pnt.map.containsKey(cur)) {
				pnt = pnt.map.get(cur);
			} else {
				TrieNode node = new TrieNode(cur);
				pnt.map.put(cur, node);
				pnt = node;
			}
		}
		pnt.map.put('#', new TrieNode('#'));
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode pnt = root;
		for(int i=0; i<word.length(); i++) {
			Character cur = word.charAt(i);
			if(!pnt.map.containsKey(cur)) {
				return false;
			}
			pnt = pnt.map.get(cur);
		}
		return pnt.map.containsKey('#');
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode pnt = root;
		for(int i=0; i<prefix.length(); i++) {
			Character cur = prefix.charAt(i);
			if(!pnt.map.containsKey(cur)) {
				return false;
			}
			pnt = pnt.map.get(cur);
		}
		return true;
	}
}
