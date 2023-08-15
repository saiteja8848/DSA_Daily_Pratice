package LinkedList;

public class ReorderList {

	public void reorderList(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = reverse(getMiddle(head));

		while (p1 != p2) {
			ListNode temp = p1.next;
			p1.next = p2;
			p1 = p2;
			p2 = temp;
		}
	}

	public ListNode getMiddle(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head.next.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.next;
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next; // next target node
			head.next = prev; // reverse direction
			prev = head; // set previous node
			head = temp; // next target node
		}
		return prev;
	}

}
