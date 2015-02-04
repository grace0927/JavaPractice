/**
 * 
 */
package leetCode;

import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
        int len = lists.size();
		if(len < 1) {
			return null;
		}
		if(len == 1) {
			return lists.get(0);
		}
		ListNode left = mergeKLists(lists.subList(0, len/2));
		ListNode right = mergeKLists(lists.subList(len/2, len));
		ListNode res = new ListNode(0);
		ListNode itor = res;
		
		while(left != null && right != null) {
			if(left.val > right.val) {
				itor.next = right;
				right = right.next;
			} else {
				itor.next = left;
				left = left.next;
			}
			itor = itor.next;
		}
		
		if(left != null) {
			itor.next = left;
		}
		if(right != null) {
			itor.next = right;
		}
		
		return res.next;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
