/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements.
 * Each element must have the same probability of being returned.
 *
 */
public class InsertDeleteGetRandom {

	private HashMap<Integer, Integer> indexMap, valueMap;
	private int size = 0;
	private Random rand;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {
		indexMap = new HashMap<>();
		valueMap = new HashMap<>();
		rand = new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (valueMap.containsKey(val)) {
			return false;
		}
		size++;
		valueMap.put(val, size);
		indexMap.put(size, val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!valueMap.containsKey(val)) {
			return false;
		}

		int idx = valueMap.get(val);
		valueMap.remove(val);
		indexMap.remove(idx);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (indexMap.size()==0) {
			return 0;
		}

		int idx = rand.nextInt(size+1);

		while (!indexMap.containsKey(idx)) {
			idx = rand.nextInt(size+1);
		}

		return indexMap.get(idx);
	}
}
