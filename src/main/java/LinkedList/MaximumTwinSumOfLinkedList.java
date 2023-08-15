package LinkedList;

public class MaximumTwinSumOfLinkedList {

	public int pairSum(ListNode head) {
		ListNode fast = head, slow = head;
		ListNode prev = null, next = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}

		int max = 0;
		while (slow != null) {
			max = Integer.max(max, prev.val + slow.val);
			prev = prev.next;
			slow = slow.next;
		}
		return max;
	}

}
