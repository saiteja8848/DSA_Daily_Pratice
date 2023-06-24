package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> solution = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = i;
		}
		generatePermutations(nums, solution, temp, k);
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


