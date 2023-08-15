package LinkedList;

public class SortList {

}

class SolutionAS {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = middleNode(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return mergeTwoLists(left, right);
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head, mid;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		mid = slow.next;
		slow.next = null;
		return mid;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1), current = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		current.next = l1 != null ? l1 : l2;
		return dummyHead.next;
	}
}

//Brute force
// public ListNode sortList(ListNode head) {
//     if(head==null || head.next==null)
//          return head;

//     ListNode curr = head;
//     while(curr!=null){
//         ListNode iter=curr;
//         ListNode minNode=curr;
//         while(iter!=null){
//             if(iter.val<minNode.val)
//                 minNode=iter;
//             iter=iter.next;
//         }
//         int temp = curr.val;
//         curr.val=minNode.val;
//         minNode.val=temp;
//         curr=curr.next;
//     }

//     return head;
// }