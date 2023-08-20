package FastAndSlowPointers;

public class SwapNodesInLinkedList {
	public ListNode swapNodes(ListNode head, int k) {

		// simply swap the kth node from start with kth node from end
		// fast and slow pointer technique to detect, the kth start and kth end
		k = k - 1;
		ListNode firstNode = head;
		while (k > 0) {
			firstNode = firstNode.next;
			k--;
		}

		ListNode secondNode = head;
		ListNode temp = firstNode;
		while (temp.next != null) {
			secondNode = secondNode.next;
			temp = temp.next;
		}

		int t = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = t;
		return head;

	}
}
