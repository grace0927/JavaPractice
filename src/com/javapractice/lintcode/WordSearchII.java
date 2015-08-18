/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author feng
 * http://www.lintcode.com/en/problem/word-search-ii/
 * Given a matrix of lower alphabets and a dictionary. 
 * Find all words in the dictionary that can be found in the matrix. 
 * A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 
 * Given matrix:
 * doaf
 * agai
 * dcan
 * and dictionary:
 * {"dog", "dad", "dgdg", "can", "again"}
 * return {"dog", "dad", "can", "again"}
 * Using trie to implement your algorithm.
 *
 */
public class WordSearchII {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
		Node root = new Node('#');
		buildTrie(root, words);
		
		ArrayList<String> res = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		int row = board.length;
		int col = board[0].length;
		boolean[][] visit = new boolean[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(root.map.containsKey(board[i][j])) {
					visit[i][j] = true;
					str.append(board[i][j]);
					wordSearchIIUtil(res, board, visit, root.map.get(board[i][j]), i, j, str);
					str.deleteCharAt(str.length()-1);
					visit[i][j] = false;
				}
			}
		}
		
		return res;
    }
	
	public void wordSearchIIUtil(ArrayList<String> res, char[][] board, boolean[][] visit, Node root, int row, int col, StringBuilder str) {
		if(root.map.containsKey('#')) {
			if(!str.equals("")) {
			    String cur = new String(str);
			    if(!res.contains(cur)) {
			        res.add(new String(str));
			    }
			}
		}
		if(col+1 < board[0].length) {
			if(root.map.containsKey(board[row][col+1]) && !visit[row][col+1]) {
				str.append(board[row][col+1]);
				visit[row][col+1] = true;
				wordSearchIIUtil(res, board, visit, root.map.get(board[row][col+1]), row, col+1, str);
				str.deleteCharAt(str.length()-1);
				visit[row][col+1] = false;
			}
		}
		if(col-1 >= 0) {
			if(root.map.containsKey(board[row][col-1]) && !visit[row][col-1]) {
				str.append(board[row][col-1]);
				visit[row][col-1] = true;
				wordSearchIIUtil(res, board, visit, root.map.get(board[row][col-1]), row, col-1, str);
				str.deleteCharAt(str.length()-1);
				visit[row][col-1] = false;
			}
		}
		if(row+1 < board.length) {
			if(root.map.containsKey(board[row+1][col]) && !visit[row+1][col]) {
				str.append(board[row+1][col]);
				visit[row+1][col] = true;
				wordSearchIIUtil(res, board, visit, root.map.get(board[row+1][col]), row+1, col, str);
				str.deleteCharAt(str.length()-1);
				visit[row+1][col] = false;
			}
		}
		if(row-1 >= 0) {
			if(root.map.containsKey(board[row-1][col]) && !visit[row-1][col]) {
				str.append(board[row-1][col]);
				visit[row-1][col] = true;
				wordSearchIIUtil(res, board, visit, root.map.get(board[row-1][col]), row-1, col, str);
				str.deleteCharAt(str.length()-1);
				visit[row-1][col] = false;
			}
		}
	}
	
	public void buildTrie(Node root, ArrayList<String> words) {
		for(String word:words) {
			insert(root, word);
		}
	}
	
	public void insert(Node root, String word) {
		if(word.equals("")) {
			root.map.put('#', new Node('#'));
			return ;
		}
		if(root.map.containsKey(word.charAt(0))) {
			insert(root.map.get(word.charAt(0)), word.substring(1));
		} else {
			Node cur = new Node(word.charAt(0));
			root.map.put(word.charAt(0), cur);
			insert(cur, word.substring(1));
		}
	}
	
	class Node {
		char val;
		public HashMap<Character, Node> map = new HashMap<>();
		public Node(char val) {
			this.val = val;
		}
    }
}
