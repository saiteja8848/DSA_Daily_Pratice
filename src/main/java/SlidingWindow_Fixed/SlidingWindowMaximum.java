package SlidingWindow_Fixed;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k)
			return new int[0];

		int len = nums.length;
		int[] result = new int[len - k + 1];
		int idx = 0;
		// stores only the indexes of the element
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < len; i++) {
			// remove previousWindowElement
			if (!queue.isEmpty() && i - k == queue.peekFirst())
				queue.pollFirst();

			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
				queue.pollLast();

			queue.addLast(i);

			// add to solution if we hit the window boundary - maxElement -first
			if (i - k + 1 >= 0)
				result[idx++] = nums[queue.peekFirst()];
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
