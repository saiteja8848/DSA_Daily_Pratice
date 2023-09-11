package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElementToRight {
	static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		// Initialize the result ArrayList with -1 values.
		for (int i = 0; i < n; i++) {
			result.add(-1);
		}

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr.get(i) < arr.get(stack.peek())) {
				int poppedIndex = stack.pop();
				result.set(poppedIndex, arr.get(i));
			}
			stack.push(i);
		}

		return result;
	}
}
