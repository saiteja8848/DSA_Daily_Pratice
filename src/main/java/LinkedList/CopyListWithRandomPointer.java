package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	public ListNode copyRandomList(ListNode head) {

		ListNode temp = head;
		Map<ListNode, ListNode> map = new HashMap<>();

		while (temp != null) {
			map.put(temp, new ListNode(temp.val));
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			map.get(temp).next = map.get(temp.next);
			map.get(temp).random = map.get(temp.random);
			temp = temp.next;
		}

		return map.get(head);
	}

}
