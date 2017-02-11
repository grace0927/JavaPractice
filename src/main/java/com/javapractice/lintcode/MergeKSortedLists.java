/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * Given lists:
 * [
 *   2->4->null,
 *   null,
 *   -1->null
 * ],
 * return -1->2->4->null.
 *
 */
public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
		if(lists == null || lists.size() == 0) {
			return null;
		}
		int len = lists.size();
		if(len == 1) {
			return lists.get(0);
		}
		
		List<ListNode> first = new ArrayList<>();
		List<ListNode> second = new ArrayList<>();
		for(int i=0; i<len; i++) {
			if(i < len/2) {
				first.add(lists.get(i));
			} else {
				second.add(lists.get(i));
			}
		}
		ListNode one = mergeKLists(first);
		ListNode two = mergeKLists(second);
		ListNode res = new ListNode(0);
		ListNode pnt = res;
		
		while(one!=null && two!=null) {
			if(one.val < two.val) {
				pnt.next = one;
				one = one.next;
				pnt = pnt.next;
				pnt.next = null;
			} else {
				pnt.next = two;
				two = two.next;
				pnt = pnt.next;
				pnt.next = null;
			}
		}
		if(one!=null) {
			pnt.next = one;
		} else {
			pnt.next = two;
		}
		
		return res.next;
    }
}
