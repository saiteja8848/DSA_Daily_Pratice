package LinkedList;

public class ReverseLinkedList {

	 //Brute force and TC: o(n) AND SC: O(n)
    // public ListNode reverseList(ListNode head) {
    //     if(head==null)
    //        return null;
        
    //     if(head.next==null)
    //        return head;
        
    //     Stack<Integer> stack = new Stack<>();
    //     ListNode cur = head;
    //     while(cur!=null){
    //       stack.push(cur.val);  
    //       cur=cur.next;           
    //     }

    //    ListNode dummy = new ListNode(0);
    //    ListNode ptr=dummy;
       
    //    while(!stack.isEmpty()){
    //        ptr.next= new ListNode(stack.pop());
    //        ptr=ptr.next;
    //    }

    //    return dummy.next;
    // }

   // OPtimized - Tc: o(n) and sc: O(1)
    public ListNode reverseList(ListNode head) {
        //No elements
        if(head==null)
           return null;

        //it means only a single element
        if(head.next==null) 
           return head;
         
        ListNode current = head;
        ListNode next=null, prev=null;

        while(current!=null){
            next = current.next; // first take the next pointer of the current
            current.next=prev; // Now update the current with previous
            prev=current; // now the current will act as previous to next element
            current = next; // move forward
        }
        
        return prev; // after reversal prev will always point to last, which head

    }

}
