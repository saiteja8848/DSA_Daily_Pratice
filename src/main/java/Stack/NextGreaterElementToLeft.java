package Stack;

import java.util.Stack;

public class NextGreaterElementToLeft {

	public static int[] previousGreaterElement(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			// Pop elements from the stack while they are smaller than the current element
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
				stack.pop();
			}

			// If the stack is empty, there is no previous greater element
			// Otherwise, the previous greater element is at the top of the stack
			result[i] = stack.isEmpty() ? -1 : stack.peek();

			// Push the current element onto the stack
			stack.push(nums[i]);
		}

		return result;
	}

	// Remove k digits
	// Previous greater element or Next greater element to left
	public String removeKdigits(String num, int k) {
		Stack<Character> s = new Stack<>();

		for (char c : num.toCharArray()) {
			// loop means curr ele is less then the peek (there is decline in ele) whenever
			// find decline pop peek
			// left ele have more weight,thatswhy we poping it
			while (!s.isEmpty() && s.peek() > c && k > 0) {
				s.pop();
				k--;
			}
			// only push if stack empty or curr is not "0"
			// bcz if stack is empty and 0 comes then have to skip 0,don''t push;
			if (!s.isEmpty() || c != '0')
				s.push(c);
		}

		// imagine a case 123,k=3
		// in it nothing will pop , no decline in no.s
		// but k is still same
		// so just pop from stack(from right side of string), stk already contain ele in
		// increasing order ex : 112 , k=1
		while (!s.isEmpty() && k-- != 0) {
			s.pop();
		}

		if (s.isEmpty())
			return "0";

		String res = "";
		while (!s.isEmpty()) {
			res = s.pop() + res;
		}

		return res;

	}

}
