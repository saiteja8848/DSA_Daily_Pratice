package LinkedList;

import java.util.HashMap;
import java.util.Map;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

	public Node(int val2, Node next2, Node random2) {
		// TODO Auto-generated constructor stub
	}
}

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
	
	   public Node copyRandomList(Node head) {
	        if(head==null) return null;
	        
	        Node temp=head;
	        
	        while(temp!=null){
	            temp.next=new Node(temp.val,temp.next,temp.random);
	            temp=temp.next.next;
	        }
	        
	        //Update the random 
	        Node newHead=head.next;
	        temp=head;
	        
	        while(temp!=null){
	            if(temp.next.random!=null) 
	                temp.next.random=temp.next.random.next;
	            temp=temp.next.next;
	        }
	        
	        //Unwinding the list
	        temp=head;
	        
	        while(temp!=null){
	            Node copy=temp.next;
	            temp.next=copy.next;
	            if(copy.next!=null) 
	                copy.next=temp.next.next;
	            temp=temp.next;
	        }
	        
	        return newHead;
	    }

}
