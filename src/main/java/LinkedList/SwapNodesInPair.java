package LinkedList;

public class SwapNodesInPair {

//  public ListNode swapPairs(ListNode head) {

//     if(head==null||head.next==null)
//         return head;

//     ListNode thirdElement = head.next.next;

//     //Swap 1st and 2nd elements (i mean elements in the list)
//     ListNode secondElement = head.next;
//     head.next.next=head;

//     head.next = swapPairs(thirdElement);
//     return secondElement;

// }

	public ListNode swapPairs(ListNode head) {

		ListNode prevNode = new ListNode(0); // Node situated before the two to-be-swapped nodes
		prevNode.next = head; // Starting before head
		ListNode newHead = prevNode; // Storing a reference for returning

		while (prevNode.next != null && prevNode.next.next != null) {

			// Declare // ...[prev]-->[node1]-->[node2]-->[next]...
			ListNode node1 = prevNode.next;
			ListNode node2 = node1.next;
			ListNode nextNode = node2.next;

			// Swap
			prevNode.next = node2; // ...[prev]-->[node2]<--[node1] [next]...
			node2.next = node1; // ...[prev]-->[node2]<-->[node1] [next]...
			node1.next = nextNode; // ...[prev]-->[node2]-->[node1]-->[next]...

			// Move
			prevNode = node1; // ...[...]-->[node2]-->[node1/prev]-->[next]...
		}

		return newHead.next;
	}

}
