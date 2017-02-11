/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 */
public class SortCharactersByFrequency {
	class Node {
		public Node(char c) {
			this.c = c;
			count = 0;
		}

		char c;
		int count;
	}

	public String frequencySort(String s) {
		// corner case
		if(s.equals("")) {
			return "";
		}

		// init variables
		HashMap<Character, Node> map = new HashMap<>();
		PriorityQueue<Node> heap = new PriorityQueue<>(s.length(), new Comparator<Node>(){
		   public int compare(Node a, Node b) {
			   return b.count - a.count;
		   }
		});
		StringBuilder sb = new StringBuilder();

		// loop over to create Node
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, new Node(c));
			}
			map.get(c).count++;
		}

		// loop over map to create max heap
		for(char c:map.keySet()) {
			heap.add(map.get(c));
		}

		// from heap to construct string
		while(!heap.isEmpty()) {
			Node node = heap.poll();
			for(int i=0; i<node.count; i++) {
				sb.append(node.c);
			}
		}

		return sb.toString();
	}
}
