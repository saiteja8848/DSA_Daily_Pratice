package FastAndSlowPointers;





//Problem Link : https://leetcode.com/problems/linked-list-cycle/
//Logic: Object moves twice as fast as other
//by the time the faster object moves x distance, slower will move x/2 distance
//Time complexity: O(n), 
//Space complexity: O(1)

public class LinkedListCycle {

	public static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		// while condition is like, can i move ahead, is means can i make a move with
		// slow and fast from current
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
