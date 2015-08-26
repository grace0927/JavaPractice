/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author jianyu
 * https://leetcode.com/problems/palindrome-linked-list/
 * Given a singly linked list, determine if it is a palindrome.
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        
        int total = 0;
        ListNode pnt = head;
        while(pnt != null) {
            pnt = pnt.next;
            total++;
        }
        
        pnt = head;
        Stack<ListNode> stack = new Stack<>();
        for(int i=0; i<total/2; i++) {
            stack.push(pnt);
            pnt = pnt.next;
        }
        if(total/2 != (total+1)/2) {
            pnt = pnt.next;
        }
        while(!stack.isEmpty()) {
            if(stack.pop().val != pnt.val) {
                return false;
            }
            pnt = pnt.next;
        }
        
        return true;
    }
}
