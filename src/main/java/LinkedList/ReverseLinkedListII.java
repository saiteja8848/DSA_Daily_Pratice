package LinkedList;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode prev = null;
		ListNode curr = head;
		while (left != 1) {
			prev = curr;
			curr = curr.next;
			left--;
			right--;
		}

		ListNode start = prev;
		ListNode end = curr;
		ListNode next = null;
		while (right != 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			right--;
		}

		if (start != null)
			start.next = prev;
		else
			head = prev;

		end.next = curr;

		return head;

	}

}
