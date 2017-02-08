/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed
 * by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.
 * Examples 1
 * Input:
 *    5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *    5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */
public class MostFrequentSubtreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		if(root==null) {
			return new int[0];
		}

		HashMap<Integer, Integer> subtreeSum = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		int maxFrequence = 0;

		// traverse and sum
		traverseAndSum(root, subtreeSum);

		// loop over hash map to find most frequent subtree sum
		for(int i:subtreeSum.keySet()) {
			int frequence = subtreeSum.get(i);
			if(frequence>maxFrequence) {
				res = new ArrayList<>();
				res.add(i);
				maxFrequence = frequence;
			} else if(frequence==maxFrequence) {
				res.add(i);
			}
		}
		return convertToArray(res);
	}

	public int[] convertToArray(ArrayList<Integer> list) {
		int[] res = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public int traverseAndSum(TreeNode root, HashMap<Integer, Integer> map) {
		// corner case
		if(root==null) {
			return 0;
		}

		// init variable
		int sum=root.val;

		// traverse subtree
		sum += traverseAndSum(root.left, map) + traverseAndSum(root.right, map);

		if(!map.containsKey(sum)) {
			map.put(sum, 0);
		}

		map.put(sum, map.get(sum)+1);

		return sum;
	}
}
