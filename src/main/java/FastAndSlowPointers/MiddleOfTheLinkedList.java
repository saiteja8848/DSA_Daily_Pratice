package FastAndSlowPointers;


//Problem Link : https://leetcode.com/problems/middle-of-the-linked-list/
//Logic: Object moves twice as fast as other
//by the time the faster object moves x distance, slower will move x/2 distance
//Time complexity: O(n/2), 
//Space complexity: O(1)

public class MiddleOfTheLinkedList {

	public ListNode middleNode(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		// since is fast is moving ahead, so it reaches to null[end] or last node so
		// that is why we are taking fast and checking for this conditions
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
