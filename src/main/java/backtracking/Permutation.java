package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(new ArrayList<>(), ans, nums);
		return ans;
	}

	public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
		if (curr.size() == nums.length) {
			ans.add(new ArrayList<>(curr));
			return;
		}

		for (int num : nums) {
			if (!curr.contains(num)) {
				curr.add(num);
				backtrack(curr, ans, nums);
				curr.remove(curr.size() - 1);
			}
		}
	}

	// Permutations_II

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int num : nums) {
			counter.put(num, counter.getOrDefault(num, 0) + 1);
		}

		LinkedList<Integer> comb = new LinkedList<>();
		this.backtrack(comb, nums.length, counter, results);
		return results;
	}

	static public void backtrack(LinkedList<Integer> comb, Integer N, HashMap<Integer, Integer> counter,
			List<List<Integer>> results) {
		if (comb.size() == N) {
			results.add(new ArrayList<Integer>(comb));
			return;
		}

		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			Integer num = entry.getKey();
			Integer count = entry.getValue();
			if (count == 0)
				continue;
			comb.addLast(num);
			counter.put(num, count - 1);
			backtrack(comb, N, counter, results);
			comb.removeLast();
			counter.put(num, count);
		}
	}

}
