# JavaPractice

## Algorithm
practice algorithm implementation. algorithms are from:
1. famous algorithm
2. introduction to algorithm
3. geeksforgeeks
4. articles

## Backtracking
special practice for backtracking algorithm

## Basic
JAVA basic concept understanding.

## cc150
Cracking Code Interview Problems

## Database
JAVA Database Manager and Connection

## Design Patterns
Design pattern for JAVA. Original ideas are from:
1. GoF Design Pattern: Elements of Reusable Object-Oriented Software
2. Head First Design Pattern
3. ISBN: 9787302162063

Details:
- Factory
- Strategy

## leetcode
Leetcode Algorithm problems

##### Hash Table
1. Two Sum
use HashMap to map value to its index
lookup map for target-value.

##### Linked List
1. Add Two Numbers
iterative add from left to right, use flag to mark over 10 sum
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


## lintcode
Lintcode Algorithm problems
