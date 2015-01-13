/**
 * 
 */
package leetCode;

import java.util.Stack;

/**
 * @author feng
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) {
            return head;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode iter = head;
        
        while(iter != null) {
            stack.push(iter);
            iter = iter.next;
            if(stack.size() == k) {
                ListNode result = stack.pop();
                ListNode resultIter = result;
                while(!stack.isEmpty ()) {
                    ListNode temp = stack.pop();
                    resultIter.next = temp;
                    resultIter = resultIter.next;
                }
                resultIter.next = reverseKGroup(iter, k);
                return result;
            }
        }
        
        return head;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
