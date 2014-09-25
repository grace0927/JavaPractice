package leetCode;

public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		} else if(head.next == null) {
			return head;
		} else {
			ListNode pointer = head;
			while(pointer != null  && pointer.next != null) {
				if(pointer.next.val == pointer.val) {
					pointer.next = pointer.next.next;
					continue;
				} else {
					pointer = pointer.next;
				}
			}
		}
        return head;
    }
}
