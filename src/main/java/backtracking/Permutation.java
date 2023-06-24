package backtracking;

import java.util.ArrayList;
import java.util.List;

class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> solution = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		generatePermutations(nums, solution, temp, nums.length);
		return solution;
	}

	void generatePermutations(int[] choices, List<List<Integer>> solution, ArrayList<Integer> temp, int size) {

		if (temp.size() == size) {
			List<Integer> ds = new ArrayList<>();
			for (int i = 0; i < temp.size(); i++) {
				ds.add(temp.get(i));
			}
			solution.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < size; i++) {
			int num = choices[i];
			if (!temp.contains(num)) {
				temp.add(num);
				generatePermutations(choices, solution, temp, size);
				temp.remove(temp.size() - 1);
			}
		}

	}

}