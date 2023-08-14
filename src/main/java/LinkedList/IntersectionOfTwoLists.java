package LinkedList;

public class IntersectionOfTwoLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int countA = getCount(headA);
		int countB = getCount(headB);
		while (countA > countB) {
			headA = headA.next;
			countA--;
		}
		while (countB > countA) {
			headB = headB.next;
			countB--;
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public int getCount(ListNode head) {
		int count = 0;
		ListNode curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

}
