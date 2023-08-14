package LinkedList;

public class RemoveDuplicate {

	 public ListNode deleteDuplicates(ListNode head) {
         ListNode temp = head;
        if (head == null)
        {
            return head;
        }
        
        while (temp.next !=null)
        {
            if (temp.val != temp.next.val) {
                temp = temp.next;
            }
            else temp.next = temp.next.next;
        }
        return head;
    }

}
