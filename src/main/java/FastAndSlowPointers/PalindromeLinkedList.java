package FastAndSlowPointers;

import java.util.Stack;



//Problem Link : https://leetcode.com/problems/palindrome-linked-list/
//Logic: Object moves twice as fast as other
//by the time the faster object moves x distance, slower will move x/2 distance
//Time complexity: O(n), 
//Space complexity: O(1)

public class PalindromeLinkedList {

	public static boolean isPalindrome1(ListNode head) {

		Stack<Integer> stack = new Stack<>();

		ListNode temp = head;

		while (temp != null) {
			stack.push(temp.val);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			if (!stack.isEmpty() && stack.pop() != temp.val)
				return false;
			temp = temp.next;
		}
		return true;

	}

	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode firstHalf = head;
		ListNode secondHalf = reverse(slow.next);

		while (firstHalf != null && secondHalf != null) {
			if (firstHalf.val != secondHalf.val)
				return false;

			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}

		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode current = null, temp = head, previous = null;
		while (temp != null) {
			previous = current;
			current = temp;
			temp = current.next;
			current.next = previous;
		}
		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
