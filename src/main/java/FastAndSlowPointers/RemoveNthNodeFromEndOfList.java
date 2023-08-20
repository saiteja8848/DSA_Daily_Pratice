package FastAndSlowPointers;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(0, head);
		ListNode leftPtr = dummyNode;
		ListNode rightPtr = head;
		while (n > 0 && rightPtr != null) {
			rightPtr = rightPtr.next;
			n--;
		}
		while (rightPtr != null) {
			rightPtr = rightPtr.next;
			leftPtr = leftPtr.next;
		}
		leftPtr.next = leftPtr.next.next;
		return dummyNode.next;
	}
}
