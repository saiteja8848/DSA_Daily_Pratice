package LinkedList;

import java.util.Stack;

public class ReverseLinkedListEvenGroup {

	public ListNode reverseEvenLengthGroups(ListNode head) {
		Stack<Integer> stk = new Stack<>();

		int group = 1;
		ListNode temp = head;
		while (temp != null) {
			ListNode start = temp;
			int count = 0;

			while (count < group && temp != null) {
				stk.push(temp.val);
				temp = temp.next;
				count++;
			}

			if (count % 2 == 0) {
				while (start != temp) {
					start.val = stk.pop();
					start = start.next;
				}
			}

			group++;
		}

		return head;
	}
	
	//SECOND APPROACH WITH OUT STACK
	
	 ListNode end=null;
	    public ListNode reverseEvenLengthGroups2(ListNode head) {
	         if(head==null || head.next==null)
	              return head;
	        
	         int length = getLength(head);
	         ListNode dummy = new ListNode(0);
	         ListNode result = dummy;
	         ListNode curr=head;
	         for(int i=1;curr!=null&&length>0;i++){
	           int groupSize = Math.min(i,length);
	           if(groupSize%2==0){
	               dummy.next = reverseKGroup(curr,groupSize);
	               while(dummy.next!=null)
	                   dummy=dummy.next;
	               curr=end;
	           }else{
	              int gp=groupSize;
	              while(gp!=0&&curr!=null){ 
	               dummy.next = curr;
	               dummy=curr;
	               curr=curr.next;
	               gp--;
	              }
	           }
	           length-=groupSize;
	         }
	         return result.next;
	    }
	    
	    ListNode reverseKGroup(ListNode head, int k){
	         ListNode prev=null;
	         ListNode next=null;
	         ListNode curr=head;
	         while(k>0&&curr!=null){
	             next=curr.next;
	             curr.next=prev;
	             prev=curr;
	             curr=next;
	             k--;
	         }
	         end=curr;
	         return prev;
	    }
	    
	    int getLength(ListNode head){
	        int total=0;
	        ListNode curr=head;
	        while(curr!=null){
	            total++;
	            curr=curr.next;
	        }
	        return total;
	    }

}
