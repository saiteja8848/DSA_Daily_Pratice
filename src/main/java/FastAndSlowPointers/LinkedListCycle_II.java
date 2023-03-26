package FastAndSlowPointers;


//Problem Link : https://leetcode.com/problems/linked-list-cycle-ii/
//Logic: Object moves twice as fast as other
//by the time the faster object moves x distance, slower will move x/2 distance
//Time complexity: O(n), 
//Space complexity: O(1)


public class LinkedListCycle_II {

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null) {
			return null; // no circle
		}
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) { // circle detected
				
				//Suppose there is a cycle found from lastNode to 3rdNode in LinkedList of size 5
				// Our current head is pointing to 0th index, but we need to know startingPointing 3rd, so move both fast and head
				// because we cann't say fast.next because it will work when loop is at lastNode, fast -> loop is at some mid node
				// so better move head and fast pointer, it will help to get start point of the loop
				while (head != fast) {
					fast = fast.next;
					head = head.next;
				}
				return head;
			}
		}
		return null; // no circle
	}

	public static void main(String[] args) {
	}

}
