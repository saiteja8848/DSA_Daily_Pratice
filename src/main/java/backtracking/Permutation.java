package backtracking;

import java.util.ArrayList;
import java.util.List;

class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> solution = new ArrayList<>();
		generatePermutations(nums, solution, 0, nums.length);
		return solution;
	}

	void generatePermutations(int[] choices, List<List<Integer>> solution, int tempIndex, int size) {

		if (tempIndex == size) {
			List<Integer> ds = new ArrayList<>();
			for (int i = 0; i < choices.length; i++) {
				ds.add(choices[i]);
			}
			solution.add(new ArrayList<>(ds));
			return;
		}

		for (int i = tempIndex; i < size; i++) {
			int x = choices[i];
			choices[i] = choices[tempIndex];
			choices[tempIndex] = x;
			generatePermutations(choices, solution, tempIndex + 1, size);
			x = choices[i];
			choices[i] = choices[tempIndex];
			choices[tempIndex] = x;

		}

	}

}


