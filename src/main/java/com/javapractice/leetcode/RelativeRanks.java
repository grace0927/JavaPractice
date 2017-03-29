/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/relative-ranks/
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores,
 * so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 *
 */
public class RelativeRanks {
	class Node {
		int index, val;

		public Node(int i, int val) {
			this.index = i;
			this.val = val;
		}
	}

	public String[] findRelativeRanks(int[] nums) {
		PriorityQueue<Node> heap = new PriorityQueue<>( new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return b.val - a.val;
			}
		} );

		for (int i=0; i<nums.length; i++) {
			heap.add(new Node(i, nums[i]));
		}

		String[] result = new String[nums.length];
		int rank = 1;
		while(!heap.isEmpty()) {
			Node node = heap.poll();
			result[node.index] = getRankString(rank);
			rank++;
		}

		return result;
	}

	public String getRankString(int rank) {
		switch(rank) {
			case 1:
				return "Gold Medal";
			case 2:
				return "Silver Medal";
			case 3:
				return "Bronze Medal";
		}

		return rank+"";
	}
}
