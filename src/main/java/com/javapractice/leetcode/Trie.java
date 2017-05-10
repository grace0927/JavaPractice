/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 */
 public class Trie {
	 class TrieNode {
		 char c;
		 boolean isLeaf;
		 HashMap<Character, TrieNode> children;

		 public TrieNode(char c) {
			 this.c = c;
			 isLeaf = false;
			 children = new HashMap<>();
		 }
	 }

	 TrieNode root;

	 /** Initialize your data structure here. */
	 public Trie() {
		 root = new TrieNode('#');
	 }

	 /** Inserts a word into the trie. */
	 public void insert(String word) {
		 TrieNode pnt = root;
		 for (char c:word.toCharArray()) {
			 if (!pnt.children.containsKey(c)) {
				 pnt.children.put(c, new TrieNode(c));
			 }
			 pnt = pnt.children.get(c);
		 }
		 pnt.isLeaf = true;
	 }

	 /** Returns if the word is in the trie. */
	 public boolean search(String word) {
		 TrieNode endNode = findEndNode(word);

		 return endNode==null ? false : endNode.isLeaf;
	 }

	 /** Returns if there is any word in the trie that starts with the given prefix. */
	 public boolean startsWith(String prefix) {
		 TrieNode endNode = findEndNode(prefix);

		 return endNode==null ? false : true;
	 }

	 private TrieNode findEndNode(String prefix) {
		 TrieNode pnt = root;
		 for (char c:prefix.toCharArray()) {
			 if (!pnt.children.containsKey(c)) {
				 return null;
			 }
			 pnt = pnt.children.get(c);
		 }

		 return pnt;
	 }
 }

 /**
  * Your Trie object will be instantiated and called as such:
  * Trie obj = new Trie();
  * obj.insert(word);
  * boolean param_2 = obj.search(word);
  * boolean param_3 = obj.startsWith(prefix);
  */
