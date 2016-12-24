# Linked List

1. [Add Two Numbers](#add-two-numbers)
2. [Merge Two Sorted Lists](#merge-two-sorted-lists)
3. [Swap Nodes in Pairs](#swap-nodes-in-pairs)
4. [Reverse Nodes in k-Group](#reverse-nodes-in-k-group)
5. [Remove Duplicates from Sorted List II](#remove-duplicates-from-sorted-list-ii)
6. [Remove Duplicates from Sorted List](#remove-duplicates-from-sorted-list)
7. [Reverse Linked List II](#reverse-linked-list-ii)
8. [Reorder List](#reorder-list)
9. [Insertion Sort List](#insertion-sort-list)
10. [Sort List](#sort-list)
11. [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
12. [Remove Linked List Elements](#remove-linked-list-elements)
13. [Reverse Linked List](#reverse-linked-list)
14. [Delete Node in a Linked List](#delete-node-in-a-linked-list)

#Add Two Numbers   
Q: You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.   
A: iterative add from left to right, use flag to mark over 10 sum. O(n)   
```
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   ListNode dummy = new ListNode(0);
   ListNode pnt = dummy;
   dummy.next = pnt;
   
   boolean overflow = false;
   while(l1!=null && l2!=null) {
       int sum = (overflow)?1+l1.val+l2.val:l1.val+l2.val;
       if(sum>=10) {
           sum -= 10;
           overflow = true;
       } else {
           overflow = false;
       }
       ListNode tmp = new ListNode(sum);
       pnt.next = tmp;
       pnt = tmp;
       l1 = l1.next;
       l2 = l2.next;
   }
   ListNode l = (l1!=null)?l1:l2;
   while(l!=null) {
       int sum = (overflow)?1+l.val:l.val;
       if(sum>=10) {
           sum -= 10;
           overflow = true;
       } else {
           overflow = false;
       }
       ListNode tmp = new ListNode(sum);
       pnt.next = tmp;
       pnt = tmp;
       l = l.next;
   }
   if(overflow) {
       ListNode tmp = new ListNode(1);
       pnt.next = tmp;
   }
   
   return dummy.next;
}
```

#Merge Two Sorted Lists   
Q: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.   
```
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode pnt = new ListNode(0);
    ListNode head = pnt;
    
    while(l1!=null && l2!=null) {
        if(l1.val>l2.val) {
            pnt.next = l2;
            l2 = l2.next;
        } else {
            pnt.next = l1;
            l1 = l1.next;
        }
        pnt = pnt.next;
    }
    while(l1!=null) {
        pnt.next = l1;
        l1 = l1.next;
        pnt = pnt.next;
    }
    while(l2!=null) {
        pnt.next = l2;
        l2 = l2.next;
        pnt = pnt.next;
    }
    
    return head.next;
}
```

#Swap Nodes in Pairs   
Q: Given a linked list, swap every two adjacent nodes and return its head.   
For example, Given 1->2->3->4, you should return the list as 2->1->4->3. Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.   
```
public ListNode swapPairs(ListNode head) {
    if(head==null || head.next==null) {
        return head;
    }
    
    ListNode dummy = new ListNode(0);
    ListNode pnt = dummy;
    dummy.next = head;
    ListNode prev = head;
    while(prev!=null && prev.next!=null) {
        pnt.next = prev.next;
        ListNode next = prev.next.next;
        prev.next.next = prev;
        prev.next = next;
        pnt = prev;
        prev = prev.next;
    }
    
    return dummy.next;
}
```

#Reverse Nodes in k-Group   
Q: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.   
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
```
public ListNode reverseKGroup(ListNode head, int k) {
    if(count(head)<k) {
        return head;
    }
    
    ListNode dummy = head;
    ListNode pnt = head.next;
    ListNode prev = null;
    head.next = prev;
    prev = head;
    head = pnt;
    for(int i=1; i<k; i++) {
        pnt = head.next;
        head.next = prev;
        prev = head;
        head = pnt;
    }
    dummy.next = reverseKGroup(head, k);
    
    return prev;
}

private int count(ListNode head) {
    ListNode pnt = head;
    int cnt = 0;
    while(pnt!=null) {
        pnt = pnt.next;
        cnt++;
    }
    return cnt;
}
```

#Remove Duplicates from Sorted List II   
Q: Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.   
```
public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0), prev = dummy, pnt=head;
    dummy.next = head;
    while(pnt!=null && pnt.next!=null) {
        if(pnt.val==pnt.next.val) {
            int val = pnt.val;
            while(pnt!=null && pnt.val==val) {
                pnt = pnt.next;
            }
            prev.next = pnt;
        } else {
            prev = pnt;
            pnt = pnt.next;
        }
    }
    return dummy.next;
}
```

##Remove Duplicates from Sorted List   
Q: Given a sorted linked list, delete all duplicates such that each element appear only once. For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.   
```
public ListNode deleteDuplicates(ListNode head) {
    ListNode pnt = head;
    while(pnt!=null && pnt.next!=null) {
        if(pnt.val==pnt.next.val) {
            pnt.next = pnt.next.next;
        } else {
            pnt = pnt.next;
        }
    }
    return head;
}
```

##Reverse Linked List II
Q: Reverse a linked list from position m to n. Do it in-place and in one-pass.   
For example:   
Given 1->2->3->4->5->NULL, m = 2 and n = 4,   
return 1->4->3->2->5->NULL.   
Note:   
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.   
```
public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pnt = dummy;
    while(pnt!=null && m>1) {
        pnt = pnt.next;
        m--;
        n--;
    }
    ListNode pos=pnt, prev=null;
    pnt = pnt.next;
    while(pnt!=null && n>1) {
        ListNode tmp = pnt.next;
        pnt.next = prev;
        prev = pnt;
        pnt = tmp;
        n--;
    }
    if(pos.next!=null) {
        pos.next.next = pnt.next;
        pnt.next = (prev!=null)?prev:pnt.next;
        pos.next = pnt;
    }
    
    return dummy.next;
}
```

##Reorder List
Q: Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… You must do this in-place without altering the nodes' values.   
```
public void reorderList(ListNode head) {
    if(head==null || head.next==null) {
        return ;
    }
    ListNode fast=head, slow=head, pre=slow;
    // find middle node
    while(fast!=null && fast.next!=null) {
        fast = fast.next.next;
        pre = slow;
        slow = slow.next;
    }
    
    // reverse second part
    pre.next = null;
    pre = null;
    while(slow!=null) {
        fast = slow.next;
        slow.next = pre;
        pre = slow;
        slow = fast;
    }
    
    // reconstruct list
    fast = head;
    while(fast!=null && pre!=null) {
        slow = fast.next;
        fast.next = pre;
        fast = slow;
        slow = pre.next;
        pre.next = (fast!=null)?fast:slow;
        pre = slow;
    }
}
```

## Insertion Sort List
Q: Sort a linked list using insertion sort.   
```
public ListNode insertionSortList(ListNode head) {
    if(head==null) {
        return null;
    }
    ListNode pnt=head.next;
    head.next=null;
    while(pnt!=null) {
        ListNode tmp = pnt.next;
        pnt.next = null;
        if(pnt.val<head.val) {
            pnt.next = head;
            head = pnt;
        } else {
            ListNode tp=head, pre=tp;
            while(tp!=null && pnt.val>=tp.val) {
                pre = tp;
                tp = tp.next;
            }
            pre.next = pnt;
            pnt.next = tp;
        }
        pnt = tmp;
    }
    return head;
}
```

## Sort List
Q: Sort a linked list in O(n log n) time using constant space complexity.   
```
public ListNode sortList(ListNode head) {
    if(head==null || head.next==null) {
        return head;
    }
    ListNode fast=head,slow=head,pre=slow;
    while(fast!=null && fast.next!=null) {
        fast = fast.next.next;
        pre = slow;
        slow = slow.next;
    }
    pre.next = null;
    pre = sortList(head);
    slow = sortList(slow);
    
    // merge
    if(pre.val>slow.val) {
        head = slow;
        slow = slow.next;
    } else {
        head = pre;
        pre = pre.next;
    }
    fast = head;
    while(pre!=null && slow!=null) {
        if(pre.val>slow.val) {
            fast.next = slow;
            slow = slow.next;
        } else {
            fast.next = pre;
            pre = pre.next;
        }
        fast = fast.next;
    }
    fast.next = (pre!=null)?pre:slow;
    
    return head;
}
```

## Intersection of Two Linked Lists
Q: Write a program to find the node at which the intersection of two singly linked lists begins. If the two linked lists have no intersection at all, return null. The linked lists must retain their original structure after the function returns. You may assume there are no cycles anywhere in the entire linked structure. Your code should preferably run in O(n) time and use only O(1) memory.   
```
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null || headB==null) {
        return null;
    }
    ListNode pa=headA, pb=headB;
    
    while(pa!=null || pb!=null) {
        pa = (pa==null)?headB:pa;
        pb = (pb==null)?headA:pb;
        while(pa!=null && pb!=null) {
            if(pa==pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
    }
    
    return null;
}
```

##Remove Linked List Elements
Q: Remove all elements from a linked list of integers that have value val.   
```
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pnt = dummy;
    while(pnt.next!=null) {
        if(pnt.next.val==val) {
            pnt.next = pnt.next.next;
        } else {
            pnt = pnt.next;
        }
    }
    return dummy.next;
}
```

## Reverse Linked List
Q: Reverse a singly linked list.   
```
// iteratively
public ListNode reverseList(ListNode head) {
    ListNode slow=null, fast=head;
    while(fast!=null) {
        ListNode tmp = fast.next;
        fast.next = slow;
        slow = fast;
        fast = tmp;
    }
    return slow;
}
// recursively
public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null) {
        return head;
    }
    ListNode res = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return res;
}
```

##Delete Node in a Linked List
Q: Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.   
```
public void deleteNode(ListNode node) {
    while(node!=null && node.next!=null && node.next.next!=null) {
        node.val = node.next.val;
        node = node.next;
    }
    node.val = node.next.val;
    node.next = null;
}
```




