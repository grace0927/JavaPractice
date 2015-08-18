/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianyu
 *
 */
public class WordSearchII {
    class Node {
		char val;
		HashMap<Character, Node> map;
		public Node(char val) {
			this.val = val;
			map = new HashMap<>();
		}
	}
	
	public void buildTrie(Node root, String word) {
		Node pnt = root;
		for(int i=0; i<word.length(); i++) {
			char cur = word.charAt(i);
			if(pnt.map.containsKey(cur)) {
				pnt = pnt.map.get(cur);
			} else {
				Node node = new Node(cur);
				pnt.map.put(cur, node);
				pnt = node;
			}
		}
		if(!pnt.map.containsKey('#')) {
			pnt.map.put('#', new Node('#'));
		}
	}
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node('#');
		for(String word : words) {
			buildTrie(root, word);
		}
		
		boolean[][] visit = new boolean[board.length][board[0].length];
		List<String> list = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		for(int i=0; i<board.length; i++) {
		    for(int j=0; j<board[0].length; j++) {
		        if(root.map.containsKey(board[i][j])) {
		            str.append(board[i][j]);
		        	visit[i][j] = true;
		            findWordsUtil(board, visit, list, root.map.get(board[i][j]).map, str, i, j);
		            visit[i][j] = false;
		            str.deleteCharAt(str.length()-1);
		        }
		    }
		}
		
		return list;
    }
	
	public void findWordsUtil(char[][] board, boolean[][] visit, List<String> list, HashMap<Character, Node> map, StringBuilder str, int row, int col) {
		if(map.containsKey('#')) {
		    String temp = new String(str);
		    if(!list.contains(temp)) {
		        list.add(new String(str));
		    }
		}
		
		int[] rIndex = {row-1, row, row+1, row};
		int[] cIndex = {col, col-1, col, col+1};
		
		for(int i=0; i<4; i++) {
			if(rIndex[i]>=0 && rIndex[i]<board.length && cIndex[i]>=0 && cIndex[i]<board[0].length && !visit[rIndex[i]][cIndex[i]] && map.containsKey(board[rIndex[i]][cIndex[i]])) {
				visit[rIndex[i]][cIndex[i]] = true;
				str.append(board[rIndex[i]][cIndex[i]]);
				findWordsUtil(board, visit, list, map.get(board[rIndex[i]][cIndex[i]]).map, str, rIndex[i], cIndex[i]);
				str.deleteCharAt(str.length()-1);
				visit[rIndex[i]][cIndex[i]] = false;
			}
		}
    }
}
