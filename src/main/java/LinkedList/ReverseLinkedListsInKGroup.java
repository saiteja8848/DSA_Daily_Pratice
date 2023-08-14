package LinkedList;

public class ReverseLinkedListsInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		int length = 0;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = dummyHead;
		ListNode nex = dummyHead;
		while (cur.next != null) {
			length++;
			cur = cur.next;
		}
		while (length >= k) {
			cur = pre.next;
			nex = cur.next;
			for (int i = 1; i < k; i++) {
				cur.next = nex.next;
				nex.next = pre.next;
				pre.next = nex;
				nex = cur.next;
			}
			pre = cur;
			length -= k;
		}
		return dummyHead.next;
	}

}

class Solution {

	ListNode reverse(ListNode head, int k, int total) {
		if (head == null)
			return null;

		int kGroup = k;
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		while (kGroup > 0 && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			kGroup--;
		}
		total = total - k;
		head.next = (next != null && total >= k) ? reverse(next, k, total) : next;
		return prev;
	}

	ListNode reverseKGroup(ListNode head, int k) {
		int total = 0;
		ListNode temp = head;
		while (temp != null) {
			total++;
			temp = temp.next;
		}
		return reverse(head, k, total);
	}

}
