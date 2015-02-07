/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author feng
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * A linked list is given such that each node contains an additional 
 * random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            RandomListNode result = new RandomListNode(head.label);
            RandomListNode random = null;
            if(head.random != null) {
                random = new RandomListNode(head.random.label);
            }
            result.next = null;
            result.random = random;
            return result;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode result = new RandomListNode(head.label);
        RandomListNode next = new RandomListNode(head.next.label);
        RandomListNode random = null;
        if(head.random != null) {
            random = new RandomListNode(head.random.label);
        }
        result.next = next;
        result.random = random;
        map.put(head, result);
        
        RandomListNode itor = head.next;
        
        while(itor != null) {
            RandomListNode curNext = null;
            if(itor.next != null) {
                curNext = new RandomListNode(itor.next.label);
            }
            RandomListNode curRandom = null;
            if(itor.random != null) {
                if(map.containsKey(itor.random)) {
                    curRandom = map.get(itor.random);
                } else {
                    curRandom = new RandomListNode(itor.random.label);
                }
            }
            next.next = curNext;
            next.random = curRandom;
            map.put(itor, next);
            next = next.next;
            itor = itor.next;
        }
        
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
