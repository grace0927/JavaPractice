/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @author Feng
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElements {
	class Node {
		int val;
		int cnt;
		Node(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Node> map = new HashMap<>();
		LinkedList<Node> list = new LinkedList<>();

		for(int i=0; i<nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				Node node = new Node(nums[i], 0);
				map.put(nums[i], node);
				list.add(node);
			}
			map.get(nums[i]).cnt++;
		}

		Collections.sort(list, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return b.cnt-a.cnt;
			}
		});

		List<Integer> res = new ArrayList<>();
		for(int i=0; i<k; i++) {
			res.add(list.get(i).val);
		}

		return res;
	}
	// O(n) bucket sort
	// https://leetcode.com/discuss/100581/java-o-n-solution-bucket-sort
	public List<Integer> topKFrequentBucketSort(int[] nums, int k) {
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}

		return res;
	}

	public List<Integer> topKFrequentMaxHeap(int[] nums, int k) {
		// O(n)
		HashMap<Integer, Integer> frequencyMap = buildFrequencyMap(nums);

		// O(n log n)
		PriorityQueue<Map.Entry<Integer, Integer>> frequencyMaxHeap = buildFrequencyMaxHeap(frequencyMap);

		return getKFrequentElementsFromMaxHeap(frequencyMaxHeap, k);
	}

	public HashMap<Integer, Integer> buildFrequencyMap(int[] nums) {
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();

		for(int i=0; i<nums.length; i++) {
			if(!frequencyMap.containsKey(nums[i])) {
				frequencyMap.put(nums[i], 0);
			}
			frequencyMap.put(nums[i], frequencyMap.get(nums[i])+1);
		}

		return frequencyMap;
	}

	public PriorityQueue<Map.Entry<Integer, Integer>> buildFrequencyMaxHeap(HashMap<Integer, Integer> map) {
		PriorityQueue<Map.Entry<Integer, Integer>> frequencyMaxHeap = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});

		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			frequencyMaxHeap.add(entry);
		}

		return frequencyMaxHeap;
	}

	public List<Integer> getKFrequentElementsFromMaxHeap(PriorityQueue<Map.Entry<Integer, Integer>> frequencyMaxHeap, int k) {
		List<Integer> elementList = new ArrayList<>();

		for(int i=0; i<k; i++) {
			elementList.add(frequencyMaxHeap.poll().getKey());
		}

		return elementList;
	}
}
