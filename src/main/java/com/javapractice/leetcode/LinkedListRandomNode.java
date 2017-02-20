/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/linked-list-random-node/
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 */
public class CountingBits {
	HashMap<Integer, Integer> map = new HashMap<>();
	int index = 0;

	/** @param head The linked list's head.
		Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
		while(head!=null) {
			this.map.put(this.index++, head.val);
			head = head.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int rand = (int)Math.floor(Math.random() * index);

		return map.get(rand);
	}
}
