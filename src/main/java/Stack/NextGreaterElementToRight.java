package Stack;

import java.util.Stack;

public class NextGreaterElementToRight {

	// Stand at every index and ask a question by yourself, can i be a next greater
	// element for the elements which i encounter so far(stack)
	public static int[] nextGreaterElement(int[] nums, int n) {
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			// Simple logic if 4,5,6 is there, assume [4,5.. top] are in stack
			// so 6 > 5(top) it means 6 is next Greater element for 5, which so far we
			// passed through
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				int index = stack.pop();
				result[index] = nums[i];
			}
			stack.push(i);
		}

		// For elements with no greater element to the right, mark them as -1.
		while (!stack.isEmpty()) {
			int index = stack.pop();
			result[index] = -1;
		}

		return result;

	}

	// Daily temperatures
	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}

		return result;
	}

}
