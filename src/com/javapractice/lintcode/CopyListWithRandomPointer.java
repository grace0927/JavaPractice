/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 *
 */
public class CopyListWithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null || head.next==null) {
            return new RandomListNode(head.label);
        }
        // deep copy next
        RandomListNode copy = new RandomListNode(0);
        RandomListNode pntHead = head;
        RandomListNode pntCopy = copy;
        while(pntHead != null) {
            RandomListNode cur = new RandomListNode(pntHead.label);
            pntCopy.next = cur;
            pntCopy = pntCopy.next;
            pntHead = pntHead.next;
        }
        
        // deep copy rand
        pntHead = head;
        pntCopy = copy.next;
        while(pntHead != null) {
            RandomListNode rand = pntHead.random;
            if(rand == null) {
                pntCopy.random = null;
            } else {
                RandomListNode pnt1 = head;
                RandomListNode pnt2 = copy.next;
                while(pnt1!=rand) {
                    pnt1 = pnt1.next;
                    pnt2 = pnt2.next;
                }
                pntCopy.random = pnt2;
            }
            pntHead = pntHead.next;
            pntCopy = pntCopy.next;
        }
        
        return copy.next;
    }
}
