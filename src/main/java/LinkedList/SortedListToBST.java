package LinkedList;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode mid = mid(head);
		TreeNode root = new TreeNode(mid.val);
		if (head == mid)
			return root;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	public ListNode mid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = head;
		// If a personA runs 2x speec than personB, obviously personA reaches the end,
		// meanwhile personB is in the middle of the raceTrack
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		// since we are taking the mid value, just before mid value we are cutting it
		// off
		if (prev != null)
			prev.next = null;
		return slow; // slow is the mid value of the list
	}
}
