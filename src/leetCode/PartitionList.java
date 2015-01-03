/**
 * 
 */
package leetCode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/partition-list/
 * Given a linked list and a value x, partition it 
 * such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        
        ListNode itor = head;
        ListNode smallList = head;
        ListNode largeList = head;
        ListNode smallHead = head;
        ListNode largeHead = head;
        boolean large = false;
        boolean small = false;
        
        while(itor != null) {
            ListNode cur = new ListNode(itor.val);
            if(itor.val < x) {
                if(small) {
                    smallList.next = cur;
                    smallList = smallList.next;
                } else {
                    small = true;
                    smallList = cur;
                    smallHead = smallList;
                }
            } else {
                if(large) {
                    largeList.next = cur;
                    largeList = largeList.next;
                } else {
                    large = true;
                    largeList = cur;
                    largeHead = largeList;
                }
            }
            itor = itor.next;
        }
        
        if(small) {
            if(large) {
                smallList.next = largeHead;
            }
            return smallHead;
        } else {
            return largeHead;
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
